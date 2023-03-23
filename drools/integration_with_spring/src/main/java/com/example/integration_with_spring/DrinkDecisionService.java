package com.example.integration_with_spring;

import com.example.integration_with_spring.facts.Drink;
import com.example.integration_with_spring.facts.Person;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DrinkDecisionService {

    public static void decide_drink(){

        // set up
        var person = new Person();
        person.setName("Taro");
        person.setAge(18);
        var drink = new Drink();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();

        // execute
        Command insertElementsCommand = CommandFactory.newInsertElements(Arrays.asList(person, drink));
        kieSession.execute(insertElementsCommand);

        System.out.println(drink);
    }

}
