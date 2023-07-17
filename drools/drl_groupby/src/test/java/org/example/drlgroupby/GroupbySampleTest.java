package org.example.drlgroupby;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupbySampleTest {

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
    public void test_平均点が80点超のクラスを抽出する() {

        // set up
        var taro = new StudentTestScore("Taro", "A", 100);
        var jiro = new StudentTestScore("Jiro", "A", 75);
        var saburo = new StudentTestScore("Saburo", "B", 89);
        var shiro = new StudentTestScore("shiro", "B", 60);
        kieSession.insert(taro);
        kieSession.insert(jiro);
        kieSession.insert(saburo);
        kieSession.insert(shiro);

        // execute
        int count = kieSession.fireAllRules();

        // assert
        assertEquals(count, 2);

    }
}
