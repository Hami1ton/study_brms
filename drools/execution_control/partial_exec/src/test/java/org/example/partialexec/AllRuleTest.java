package org.example.partialexec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllRuleTest {

    static final Logger log = LoggerFactory.getLogger(AllRuleTest.class);

    @Test
    public void test_全ルール実行() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();

        try {
            var data = new ExecutedRules();
            kieSession.insert(data);
            kieSession.fireAllRules();

            // assert
            assertEquals(Set.of("Rule_A", "Rule_B", "Rule_C", "Rule_D"), data.getExecutedRules());

        } finally {
            kieSession.dispose();
        }
    }
}
