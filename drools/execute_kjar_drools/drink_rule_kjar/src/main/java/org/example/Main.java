package org.example;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {

    public static void main(String[] args) {

        // set up
        var person = new Person();
        person.setName("Taro");
        person.setAge(18);
        var drink = new Drink();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(person);
        kieSession.insert(drink);

        // exectute rule
        kieSession.fireAllRules();

        System.out.println(drink);

        // dispose
        kieSession.dispose();

    }
}
