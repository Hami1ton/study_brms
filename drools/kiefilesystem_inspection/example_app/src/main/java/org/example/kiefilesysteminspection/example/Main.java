package org.example.kiefilesysteminspection.example;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Main {

    public static void main(String[] args) {
        var person = new Person();
        person.setName("Taro");
        person.setAge(22);
        var drink = new Drink();

        // set up Kie Session
        var kSession = kSessionFromStr(getRuleStr());

        // execute rule
        kSession.insert(person);
        kSession.insert(drink);
        kSession.fireAllRules();

        System.out.println(drink);

        // dispose
        kSession.dispose();
    }

    public static KieSession kSessionFromStr(String ruleStr) {
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        KieFileSystem kfs = ks.newKieFileSystem();

        kfs.write("src/main/resources/org/example/kiefilesysteminspection/example/Drink.drl", ruleStr);
        KieBuilder kb = ks.newKieBuilder(kfs);
        kb.buildAll();

        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
        KieSession kSession = kContainer.newKieSession();

        return kSession;
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
                   "        $drink.setName( \"Orange Juice\" ); \n" +
                   "        $drink.setCharge( 200 ); \n" +
                   "end \n" +

                   "rule \"Adult\" \n" +
                   "    when \n" +
                   "        $person : Person( age >= 20 ) \n" +
                   "        $drink : Drink() \n" +
                   "    then \n" +
                   "        $drink.setName( \"Beer\" ); \n" +
                   "        $drink.setCharge( 500 ); \n" +
                   "end \n";
        return rule;
    }
}