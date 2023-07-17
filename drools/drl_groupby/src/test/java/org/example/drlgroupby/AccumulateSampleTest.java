package org.example.drlgroupby;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccumulateSampleTest {

    KieSession kieSession;

    @BeforeEach
    void initKieSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        kieSession = kieContainer.newKieSession();
    }

    @AfterEach
    void disposeKieSession() {
        kieSession.dispose();
    }

    @Test
    public void test_クラス全体の平均点を計算する() {

        // set up
        var StudentTestScore = new StudentTestScore("", "", 100);
        kieSession.insert(StudentTestScore);

        // execute
        int count = kieSession.fireAllRules();

        // assert
        assertEquals(count, 1);

    }
}
