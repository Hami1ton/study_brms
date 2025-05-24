package org.example.drlonyaml;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.drools.drlonyaml.todrl.YAMLtoDrlDumper;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DrinkRuleTest {

    static final Logger log = LoggerFactory.getLogger(DrinkRuleTest.class);

    @Test
    public void test_drink() throws Exception {

        String yaml = readResourceFileAsString("org/example/drlonyaml/DrinkRule.drl.yaml");
        String drl = YAMLtoDrlDumper.yaml2drl(yaml);
        log.info("\n" + drl);

        KieBase kieBase = createKieBase(drl);
        KieSession kieSession = kieBase.newKieSession();

        try {
            // set up
            var person = new Person();
            person.setName("Taro");
            person.setAge(18);
            var drink = new Drink();

            kieSession.insert(person);
            kieSession.insert(drink);

            // exectute rule
            kieSession.fireAllRules();
            assertEquals("Orange Juice", drink.getName());

        } finally {
            // dispose
            kieSession.dispose();
        }
    }

    private String readResourceFileAsString(String yamlFilePath) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(yamlFilePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + yamlFilePath);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return reader.lines().collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read file: " + yamlFilePath, e);
        }
    }

    private KieBase createKieBase(String drl) {
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        KieFileSystem kfs = ks.newKieFileSystem();

        kfs.write("src/main/resources/org/example/drlonyaml/DrinkRule.drl", drl);
        KieBuilder kb = ks.newKieBuilder(kfs);
        kb.buildAll();

        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
        return kContainer.getKieBase();
    }
}
