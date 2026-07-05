package org.example.partialexec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleLineTest {

    static final Logger log = LoggerFactory.getLogger(SingleLineTest.class);

    @Test
    public void test_指定した単一ルールのみを動かす() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();

        try {
            var data = new ExecutedRules();
            kieSession.insert(data);

            // 「Rule_A」のみを実行
            kieSession.fireAllRules( new RuleNameEqualsAgendaFilter( "Rule_A" ) );

            // assert
            assertEquals(Set.of("Rule_A"), data.getExecutedRules());

        } finally {
            kieSession.dispose();
        }
    }
}
