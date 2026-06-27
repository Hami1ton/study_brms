package org.example.ruleunit.drlsample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.jupiter.api.Test;

public class MultiRuleUnitTest {

    @Test
    public void test_2つのルールユニットを同時に使用する() {
        DrinkBeerRuleUnit beerUnit = new DrinkBeerRuleUnit();
        DrinkWineRuleUnit wineUnit = new DrinkWineRuleUnit();
        RuleUnitInstance<DrinkBeerRuleUnit> beerInstance = RuleUnitProvider.get().createRuleUnitInstance(beerUnit);
        RuleUnitInstance<DrinkWineRuleUnit> wineInstance = RuleUnitProvider.get().createRuleUnitInstance(wineUnit);

        var person = new Person("Taro", 21);
        beerUnit.getPersons().add(person);
        wineUnit.getPersons().append(person);

        // execute rule 
        beerInstance.fire();
        wineInstance.fire();

        // assert
        assertEquals(1, beerUnit.getDrinkList().size());
        var beer = beerUnit.getDrinkList().get(0);
        assertEquals("Beer", beer.getName());

        assertEquals(1, wineUnit.getDrinkList().size());
        var wine = wineUnit.getDrinkList().get(0);
        assertEquals("Wine", wine.getName());

        beerInstance.close();
        wineInstance.close();
    }
}
