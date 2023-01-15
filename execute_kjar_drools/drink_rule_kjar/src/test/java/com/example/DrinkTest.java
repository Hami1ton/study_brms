package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkTest {

    KieSession kieSession;

    @BeforeEach
    void initKieSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        kieSession = kieContainer.newKieSession();
    }

    @AfterEach
    void disposeKieSession() {
        kieSession.dispose();
    }

    @Test
    public void test_子供はジュースのみ() {

        // set up
        var person = new Person();
        person.setName("Hanako");
        person.setAge(19);
        var drink = new Drink();
        kieSession.insert(person);
        kieSession.insert(drink);

        // execute
        int count = kieSession.fireAllRules();

        // assert
        assertEquals(count, 1);
        assertEquals(drink.getName(), "Orange Juice");
        assertEquals(drink.getCharge(), 100);

    }

    @Test
    public void test_大人はビールがのめる() {

        // set up
        var person = new Person();
        person.setName("Taro");
        person.setAge(21);
        var drink = new Drink();
        kieSession.insert(person);
        kieSession.insert(drink);

        // execute
        int count = kieSession.fireAllRules();

        // assert
        assertEquals(count, 1);
        assertEquals(drink.getName(), "Beer");
        assertEquals(drink.getCharge(), 200);

    }
}
