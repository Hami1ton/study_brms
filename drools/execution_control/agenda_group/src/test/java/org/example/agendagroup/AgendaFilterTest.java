package org.example.agendagroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AgendaFilterTest {

    static final Logger log = LoggerFactory.getLogger(AgendaFilterTest.class);

    private KieContainer kieContainer;
    private KieSession kieSession;

    @BeforeEach
    public void setup() {
        KieServices ks = KieServices.Factory.get();
        kieContainer = ks.getKieClasspathContainer();
        kieSession = kieContainer.newKieSession();
    }

    @AfterEach
    public void cleanup() {
        if (kieSession != null) {
            kieSession.dispose();
        }
    }

    @Test
    public void test_指定したルール名のみ実行() {

        var data = new SampleData();
        kieSession.insert(data);

        // Phase_1
        kieSession.getAgenda().getAgendaGroup("Phase_1").setFocus();
        kieSession.fireAllRules( new RuleNameEqualsAgendaFilter( "Rule_A" ) );

        // exectute rule
        assertEquals(Arrays.asList("Rule_A"), data.getExecutedRules());
        assertEquals("Rule_A", data.getLatestRule());
    }
}