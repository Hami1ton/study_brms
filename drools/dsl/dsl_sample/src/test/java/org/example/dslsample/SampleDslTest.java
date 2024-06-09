package org.example.dslsample;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SampleDslTest {
    
    @Test
    public void test_ドリンク判定ルール_Child() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();

        // set up
        var person = new Person("太郎", 13);
        var drink = new Drink();
        kieSession.insert(person);
        kieSession.insert(drink);

        // execute
        kieSession.fireAllRules();

        // assert
        assertEquals("オレンジジュース", drink.getName());
        assertEquals(100, drink.getCharge());

        kieSession.dispose();
    }

    @Test
    public void test_ドリンク判定ルール_Adult() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();

        // set up
        var person = new Person("次郎", 31);
        var drink = new Drink();
        kieSession.insert(person);
        kieSession.insert(drink);

        // execute
        kieSession.fireAllRules();

        // assert
        assertEquals("ビール", drink.getName());
        assertEquals(200, drink.getCharge());

        kieSession.dispose();
    }

}
