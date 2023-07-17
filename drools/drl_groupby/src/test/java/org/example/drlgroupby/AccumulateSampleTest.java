package org.example.drlgroupby;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Arrays;

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
    public void test_学年全体の平均点を計算する() {

        // set up
        var taro = new StudentTestScore("Taro", "A", 100);
        var jiro = new StudentTestScore("Jiro", "A", 75);
        var saburo = new StudentTestScore("Saburo", "B", 89);
        kieSession.insert(taro);
        kieSession.insert(jiro);
        kieSession.insert(saburo);

        // execute
        int count = kieSession.fireAllRules();

        // assert
        assertEquals(count, 1);

    }
}
