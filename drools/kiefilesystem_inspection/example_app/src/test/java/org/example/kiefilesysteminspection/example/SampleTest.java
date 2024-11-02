package org.example.kiefilesysteminspection.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.kie.api.KieBase;

public class SampleTest {

    @Test
    public void test_ルール実行() {
        var person = new Person();
        person.setName("Taro");
        person.setAge(22);
        var drink = new Drink();

        // set up Kie Session
        KieBase kiebase = KieBaseCreater.create();
        var kSession = kiebase.newKieSession();
        // execute rule
        kSession.insert(person);
        kSession.insert(drink);
        kSession.fireAllRules();

        System.out.println(drink);

        assertEquals(500, drink.getCharge());
    }
}
