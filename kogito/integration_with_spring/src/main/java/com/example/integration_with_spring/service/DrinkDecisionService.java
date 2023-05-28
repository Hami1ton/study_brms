package com.example.integration_with_spring.service;

import com.example.integration_with_spring.facts.Drink;
import com.example.integration_with_spring.facts.Person;
import org.kie.api.runtime.KieRuntimeBuilder;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;


@Service
public class DrinkDecisionService {

    private final KieRuntimeBuilder kieRuntimeBuilder;

    public DrinkDecisionService(KieRuntimeBuilder kieRuntimeBuilder) {

        this.kieRuntimeBuilder = kieRuntimeBuilder;
    }

    public Drink decideDrink(Person person){
        KieSession kieSession = kieRuntimeBuilder.newKieSession();

        // set up
        Drink drink = new Drink();
        kieSession.insert(person);
        kieSession.insert(drink);

        // execute
        kieSession.fireAllRules();

        return drink;
    }

}
