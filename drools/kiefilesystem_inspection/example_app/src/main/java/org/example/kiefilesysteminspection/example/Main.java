package org.example.kiefilesysteminspection.example;

import org.kie.api.KieBase;

public class Main {

    public static void main(String[] args) {
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

        System.out.println(drink);

        // dispose
        kSession.dispose();
    }
}