package org.example.declarativeagenda;

import org.junit.jupiter.api.Test;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.DeclarativeAgendaOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeclarativeAgendaTest {
    
    @Test
    public void test_DeclarativeAgenda() {

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();

        // enable Declarative Agenda
        KieBaseConfiguration kieConf = ks.newKieBaseConfiguration();
        kieConf.setOption(DeclarativeAgendaOption.ENABLED);
        KieBase kieBase = kieContainer.newKieBase(kieConf);
        KieSession kieSession = kieBase.newKieSession();

        // insert datas
        var visitor1 = new Visitor("Hanako", 13);
        var visitor2 = new Visitor("Taro", 20);
        var visitor3 = new Visitor("Jiro", 67);
        kieSession.insert(visitor1);
        kieSession.insert(visitor2);
        kieSession.insert(visitor3);

        // execute
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup( "DeclarativeAgendaSample" ).setFocus();
        int count = kieSession.fireAllRules();

        // assert
        assertEquals(4, count);

        kieSession.dispose();
    }



}
