package org.example.ruleunit.drlsample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.jupiter.api.Test;

public class DrinkBeerTest {

    @Test
    public void test_ビール注文可否の判定_20歳以上() {
        DrinkBeerRuleUnit drinkRuleUnit = new DrinkBeerRuleUnit();
        RuleUnitInstance<DrinkBeerRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(drinkRuleUnit);

        var person = new Person("Taro", 20);
        drinkRuleUnit.getPersons().add(person);

        // execute rule 
        instance.fire();

        // assert
        assertEquals(1, drinkRuleUnit.getDrinkList().size());
        var drink = drinkRuleUnit.getDrinkList().get(0);
        assertEquals("Beer", drink.getName());

        instance.close();
    }

    @Test
    public void test_ビール注文可否の判定_20歳未満() {
        DrinkBeerRuleUnit drinkRuleUnit = new DrinkBeerRuleUnit();
        RuleUnitInstance<DrinkBeerRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(drinkRuleUnit);

        var person = new Person("Taro", 19);
        drinkRuleUnit.getPersons().add(person);

        // execute rule 
        instance.fire();

        // assert
        assertEquals(1, drinkRuleUnit.getDrinkList().size());
        var drink = drinkRuleUnit.getDrinkList().get(0);
        assertEquals("Orange Juice", drink.getName());

        instance.close();
    }
}
