package org.example.declarativeagenda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DeclarativeAgendaTest {

    static final Logger log = LoggerFactory.getLogger(DeclarativeAgendaTest.class);

    private KieContainer kieContainer;
    private KieSession kieSession;

    @BeforeEach
    public void setup() {
        KieServices ks = KieServices.Factory.get();
        kieContainer = ks.getKieClasspathContainer();
        kieSession = kieContainer.newKieSession("DeclarativeKSession");
    }

    @AfterEach
    public void cleanup() {
        if (kieSession != null) {
            kieSession.dispose();
        }
    }

    @Test
    public void test_フェーズのブロック検証() {
        // Phase_1 ⇒ Phase_3 ⇒ Phase_2 の順に流れることを検証

        var data = new SampleData();
        kieSession.insert(data);

        // execute
        kieSession.fireAllRules();

        // assert
        assertEquals(Arrays.asList("Rule_A", "Rule_C", "Rule_B"), data.getExecutedRules());
        assertEquals("Rule_B", data.getLatestRule());
    }

}