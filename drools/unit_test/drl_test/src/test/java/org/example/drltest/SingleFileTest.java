package org.example.drltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private KieServices ks = KieServices.Factory.get();

    @Test
    public void test_指定したDRLファイルのみ実行() {
        // 特定のDRLファイルのみをリソースとして追加
        KieFileSystem kfs = ks.newKieFileSystem();

        // テストしたいDRLファイル（1ファイルだけ）をクラスパスから読み込む
        kfs.write(ResourceFactory.newClassPathResource("org/example/drltest/Rule_A_B_C.drl"));
        ks.newKieBuilder(kfs).buildAll();

        KieContainer kContainer = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
        KieSession kieSession = kContainer.newKieSession();

        try {
            var data = new ExecutedRules();
            kieSession.insert(data);
            kieSession.fireAllRules();

            // assert
            assertEquals(3, data.getExecutedRules().size()); 

        } finally {
            kieSession.dispose();
        }
    }
}
