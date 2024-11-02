package org.example.kiefilesysteminspection.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.command.CommandFactory;
import org.kie.api.command.Command;


public class SampleTest {

    @Test
    public void test_ルール実行() {
        var person = new Person();
        person.setName("Taro");
        person.setAge(22);
        var drink = new Drink();

        // set up Kie Session
        KieBase kiebase = KieResourceCreater.create();
        var kSession = kiebase.newKieSession();
        // execute rule
        kSession.insert(person);
        kSession.insert(drink);
        kSession.fireAllRules();
        kSession.dispose();

        System.out.println(drink);

        assertEquals(500, drink.getCharge());
    }

    @Test
    public void test_ルール実行_stateless() {

        var person = new Person();
        person.setName("Taro");
        person.setAge(22);
        var drink = new Drink();

        // set up Kie Session
        KieContainer kiebase = KieResourceCreater.createForStateLess();
        var kSession = kiebase.newStatelessKieSession();

        Command insertElementsCommand = CommandFactory.newInsertElements(Arrays.asList(person, drink));
        kSession.execute(insertElementsCommand);
        
        assertEquals(500, drink.getCharge());
    }
}
