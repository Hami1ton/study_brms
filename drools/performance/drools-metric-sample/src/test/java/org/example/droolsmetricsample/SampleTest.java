package org.example.droolsmetricsample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;

public class SampleTest {

    
    @Test
    public void test_ドリンクの決定() {
        System.setProperty("drools.metric.logger.enabled", "true");
        System.setProperty("drools.metric.logger.threshold", "1");
        

        DrinkRuleUnit drinkRuleUnit = new DrinkRuleUnit();
        RuleUnitInstance<DrinkRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(drinkRuleUnit);

        var person = new Person("Taro", 20);
        drinkRuleUnit.getPersons().add(person);

        // execute rule 
        instance.fire();

        // assert
        var drink = drinkRuleUnit.getDrinkList().get(0);
        assertEquals("Beer", drink.getName());

        instance.close();
    }
}
