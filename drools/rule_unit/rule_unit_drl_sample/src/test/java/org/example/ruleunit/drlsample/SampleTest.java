package org.example.ruleunit.drlsample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest {

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
    public void test_ドリンクの決定() {

        // set up
        var taro = new Person("Taro", 20);
        var drink = new Drink();
        kieSession.insert(taro);
        kieSession.insert(drink);

        // execute
        kieSession.fireAllRules();

        // assert
        assertEquals("Beer", drink.getName());
    }
}
