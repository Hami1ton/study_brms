package org.example.ruleflowgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.drools.core.common.InternalAgenda;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RuleflowGroupTest {

    static final Logger log = LoggerFactory.getLogger(RuleflowGroupTest.class);

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
    public void test_実行順検証() {

        var data = new SampleData();
        kieSession.insert(data);

        // Phase_1
        ((InternalAgenda) kieSession.getAgenda()).activateRuleFlowGroup("Phase_1");
        kieSession.fireAllRules();

        // Phase_3
        ((InternalAgenda) kieSession.getAgenda()).activateRuleFlowGroup("Phase_3");
        kieSession.fireAllRules();

        // Phase_2
        ((InternalAgenda) kieSession.getAgenda()).activateRuleFlowGroup("Phase_2");
        kieSession.fireAllRules();

        // assert
        assertEquals(Arrays.asList("Rule_A", "Rule_C", "Rule_B"), data.getExecutedRules());
        assertEquals("Rule_B", data.getLatestRule());
    }

    @Test
    public void test_2フェーズのルール実行() {

        var data = new SampleData();
        kieSession.insert(data);

        // Phase_1
        kieSession.getAgenda().getAgendaGroup("Phase_1").setFocus();
        kieSession.fireAllRules();

        // Phase_3
        kieSession.getAgenda().getAgendaGroup("Phase_3").setFocus();
        kieSession.fireAllRules();

        // assert
        assertEquals(Arrays.asList("Rule_A", "Rule_C"), data.getExecutedRules());
        assertEquals("Rule_C", data.getLatestRule());
    }
}