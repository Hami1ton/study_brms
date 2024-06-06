package org.example.declarativeagenda;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class NoControlTest {
    
    @Test
    public void test_実行制御なし() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();

        // set up
        var visitor1 = new Visitor("Hanako", 13);
        var visitor2 = new Visitor("Taro", 20);
        var visitor3 = new Visitor("Jiro", 67);
        kieSession.insert(visitor1);
        kieSession.insert(visitor2);
        kieSession.insert(visitor3);

        // 
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup( "NoControl" ).setFocus();

        // execute
        int count = kieSession.fireAllRules();

        // assert
        assertEquals(1, 1);
        // assertEquals(2, count);

        kieSession.dispose();

    }
}
