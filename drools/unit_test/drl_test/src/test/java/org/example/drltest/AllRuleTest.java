package org.example.drltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class AllRuleTest {

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
    public void test_全ルール実行のテスト() {
        var data = new ExecutedRules();
        kieSession.insert(data);
        kieSession.fireAllRules();

        // assert
        assertEquals(Set.of("Rule_A", "Rule_B", "Rule_C", "Rule_D"), data.getExecutedRules());
    }
}
