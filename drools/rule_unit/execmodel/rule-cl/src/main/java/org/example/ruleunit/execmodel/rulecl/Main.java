package org.example.ruleunit.execmodel.rulecl;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.example.ruleunit.execmodel.drinkrule.DrinkRuleUnit;
import org.example.ruleunit.execmodel.drinkrule.Person;

public class Main {

    public static void main(String[] args) {
        
        DrinkRuleUnit drinkRuleUnit = new DrinkRuleUnit();
        RuleUnitInstance<DrinkRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(drinkRuleUnit);
    
        var person = new Person("Taro", 20);
        drinkRuleUnit.getPersons().add(person);

        // execute rule 
        instance.fire();
        var drink = drinkRuleUnit.getDrinkList().get(0);
        System.out.println(drink);

        instance.close();
    }
    
}
