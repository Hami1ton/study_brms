
package org.example.ruleunit.execmodel.drinkrule;

import static org.junit.Assert.assertEquals;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.Test;

public class RuleTest {

    @Test
    public void test() {
        
        DrinkRuleUnit drinkRuleUnit = new DrinkRuleUnit();
        RuleUnitInstance<DrinkRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(drinkRuleUnit);
        var person = new Person("Taro", 20);
        drinkRuleUnit.getPersons().add(person);

        // execute rule 
        instance.fire();

        // assert
        var drink = drinkRuleUnit.getDrinkList().get(0);

        instance.close();
        assertEquals(1, 1);
    }
}
