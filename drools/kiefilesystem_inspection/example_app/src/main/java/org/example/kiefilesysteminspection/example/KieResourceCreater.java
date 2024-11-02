package org.example.kiefilesysteminspection.example;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;

public class KieResourceCreater {

    public static KieBase create() {
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        KieFileSystem kfs = ks.newKieFileSystem();

        kfs.write("src/main/resources/org/example/kiefilesysteminspection/example/Drink.drl", getRuleStr());
        KieBuilder kb = ks.newKieBuilder(kfs);
        kb.buildAll();

        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
        return kContainer.getKieBase();
    }

    private static String getRuleStr() {
        String rule = "" +
                   "package org.example.kiefilesysteminspection.example \n" +
                   "import org.example.kiefilesysteminspection.example.Person \n" +
                   "import org.example.kiefilesysteminspection.example.Drink \n" +
                   "rule \"Child\" \n" +
                   "    when \n" +
                   "        $person : Person( age < 20 ) \n" +
                   "        $drink : Drink() \n" +
                   "    then \n" +
                   "        System.out.println(\"子供 ドリンク ルール発火\"); \n" +
                   "        $drink.setName( \"Orange Juice\" ); \n" +
                   "        $drink.setCharge( 200 ); \n" +
                   "end \n" +

                   "rule \"Adult\" \n" +
                   "    when \n" +
                   "        $person : Person( age >= 20 ) \n" +
                   "        $drink : Drink() \n" +
                   "    then \n" +
                   "        System.out.println(\"大人 ドリンク ルール発火\"); \n" +
                   "        $drink.setName( \"Beer\" ); \n" +
                   "        $drink.setCharge( 500 ); \n" +
                   "end \n";
        return rule;
    }

}
