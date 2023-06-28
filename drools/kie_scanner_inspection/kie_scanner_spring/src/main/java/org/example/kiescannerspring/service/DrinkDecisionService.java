package org.example.kiescannerspring.service;

import jakarta.annotation.PostConstruct;
import org.example.kiescannerspring.facts.Drink;
import org.example.kiescannerspring.facts.Person;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.lang.reflect.Method;

@Service
public class DrinkDecisionService {

    KieServices ks = KieServices.Factory.get();

    ReleaseId releaseId = ks.newReleaseId("org.example", "drink_rule_kjar", "0.0.1-SNAPSHOT");

    KieContainer kieContainer;

    @PostConstruct
    void initKieContainer() {
        this.kieContainer = ks.newKieContainer(releaseId);
        KieScanner kScanner = ks.newKieScanner(this.kieContainer);
        kScanner.start(10000L);
    }

    public Drink decideDrink(Person person) {

        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();

        // set up
        Object drinkObj = createDrinkFact(kieContainer);
        Object personObj = createPersonFact(kieContainer, person);

        // execute
        Command insertElementsCommand = CommandFactory.newInsertElements(Arrays.asList(personObj, drinkObj));
        kieSession.execute(insertElementsCommand);

        return convertToDrink(drinkObj);
    }

    private Object createPersonFact(KieContainer kContainer, Person person) {
        Object o = null;

        try {
            Class cl = kContainer.getClassLoader().loadClass("org.example.Person");
            o = cl.newInstance();
            Method setAge = cl.getMethod("setAge", int.class);
            setAge.invoke(o, person.getAge());
            Method setName = cl.getMethod("setName", String.class);
            setName.invoke(o, person.getName());

        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException
                 | InvocationTargetException |NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return o;
    }

    private Object createDrinkFact(KieContainer kContainer) {

        Object o = null;

        try {
            Class cl = kContainer.getClassLoader().loadClass("org.example.Drink");
            o = cl.newInstance();

        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return o;
    }

    private Drink convertToDrink(Object drinkObj) {
        Drink drink = new Drink();

        try {
            Field nameField = drinkObj.getClass().getDeclaredField("name");
            nameField.setAccessible(true);
            drink.setName((String) nameField.get(drinkObj));

            Field chargeField = drinkObj.getClass().getDeclaredField("charge");
            chargeField.setAccessible(true);
            drink.setCharge((Integer) chargeField.get(drinkObj));

        } catch ( NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return drink;
    }

}
