package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkTest {

    KieContainer kieContainer;

    @BeforeEach
    void initKieSession() {
        KieServices ks = KieServices.Factory.get();
        kieContainer = ks.getKieClasspathContainer();

    }

    @Test
    public void test_子供はジュースのみ() {

        // set up
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();

        var person = new Person();
        person.setName("Hanako");
        person.setAge(19);
        var drink = new Drink();
        Command insertElementsCommand = CommandFactory.newInsertElements(Arrays.asList(person, drink));

        // execute
        kieSession.execute(insertElementsCommand);

        // assert
        assertEquals(drink.getName(), "Orange Juice");
        assertEquals(drink.getCharge(), 100);

    }

    @Test
    public void test_大人はビールがのめる() {
        // set up
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();

        var person = new Person();
        person.setName("Taro");
        person.setAge(21);
        var drink = new Drink();
        Command insertElementsCommand = CommandFactory.newInsertElements(Arrays.asList(person, drink));

        // execute
        kieSession.execute(insertElementsCommand);

        // assert
        assertEquals(drink.getName(), "Beer");
        assertEquals(drink.getCharge(), 200);

    }
}
