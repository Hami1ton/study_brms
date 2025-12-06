package org.example.agendagroup;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AgendaGroupTest {

    static final Logger log = LoggerFactory.getLogger(AgendaGroupTest.class);

    @Test
    public void test_drink() throws Exception {

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();

        KieSession kieSession = kContainer.newKieSession();

        try {
            var data = new SampleData();
            kieSession.insert(data);

            // Phase_1
            kieSession.getAgenda().getAgendaGroup("Phase_1").setFocus();
            kieSession.fireAllRules();

            // Phase_2
            kieSession.getAgenda().getAgendaGroup("Phase_2").setFocus();
            kieSession.fireAllRules();

            // Phase_3
            kieSession.getAgenda().getAgendaGroup("Phase_3").setFocus();
            kieSession.fireAllRules();

            // exectute rule
            kieSession.fireAllRules();
            assertEquals(Arrays.asList("Rule_A", "Rule_B", "Rule_C"), data.getExecutedRules());
            assertEquals("Rule_C", data.getLatestRule());

        } finally {
            // dispose
            kieSession.dispose();
        }
    }
}