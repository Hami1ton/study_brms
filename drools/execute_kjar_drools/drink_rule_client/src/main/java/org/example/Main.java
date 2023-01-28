package org.example;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // set up
        var person = new Person();
        person.setName("Taro");
        person.setAge(22);
        var drink = new Drink();

        KieServices ks = KieServices.Factory.get();
        ReleaseId releaseId = ks.newReleaseId("org.example", "drink_rule_kjar", "0.0.1-SNAPSHOT");
        KieContainer kieContainer = ks.newKieContainer(releaseId);
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();

        // execute
        Command insertElementsCommand = CommandFactory.newInsertElements(Arrays.asList(person, drink));
        kieSession.execute(insertElementsCommand);

        System.out.println(drink);

    }
}
