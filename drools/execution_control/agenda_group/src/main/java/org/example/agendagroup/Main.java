package org.example.agendagroup;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {
    
    public static void main(String[] args){
       
        var data = new SampleData();

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();

        KieSession kSession = kContainer.newKieSession();

        kSession.insert(data);

        // Phase_1
        kSession.getAgenda().getAgendaGroup("Phase_1").setFocus();
        kSession.fireAllRules();

        // Phase_2
        kSession.getAgenda().getAgendaGroup("Phase_2").setFocus();
        kSession.fireAllRules();

        // Phase_3
        kSession.getAgenda().getAgendaGroup("Phase_3").setFocus();
        kSession.fireAllRules();


        System.out.println(data);

        kSession.dispose();

    }
}
