package org.example.kiescannerspring.service;

import org.example.Drink;
import org.example.Person;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DrinkDecisionService {

    KieServices ks = KieServices.Factory.get();

    ReleaseId releaseId = ks.newReleaseId("org.example", "drink_rule_kjar", "0.0.1-SNAPSHOT");

    KieContainer kieContainer = ks.newKieContainer(releaseId);;

    void DrinkDecisionService() {
        this.kieContainer = ks.newKieContainer(releaseId);

        KieScanner kScanner = ks.newKieScanner(this.kieContainer);
        kScanner.start(10000L);
    }

    public Drink decideDrink(Person person){

        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();

        // set up
        var drink = new Drink();

        // execute
        Command insertElementsCommand = CommandFactory.newInsertElements(Arrays.asList(person, drink));
        kieSession.execute(insertElementsCommand);

        return drink;
    }

}
