package org.example.partialexec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleFileTest {

    static final Logger log = LoggerFactory.getLogger(SingleFileTest.class);

    @Test
    public void test_指定したDRLファイルのみ動かす() {
        // テストしたいDRLファイル（1ファイルだけ）をクラスパスから読み込み、リソースとして追加
        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();
        kfs.write(ResourceFactory.newClassPathResource("org/example/partialexec/Rule_A_B_C.drl"));
        ks.newKieBuilder(kfs).buildAll();

        KieContainer kContainer = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
        KieSession kieSession = kContainer.newKieSession();

        try {
            var data = new ExecutedRules();
            kieSession.insert(data);
            kieSession.fireAllRules();

            // assert
            assertEquals(Set.of("Rule_A", "Rule_B", "Rule_C"), data.getExecutedRules());

        } finally {
            kieSession.dispose();
        }
    }
}
