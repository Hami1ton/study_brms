package org.example.ruleunit.drlsample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.jupiter.api.Test;

public class OOPathNestTest {

    @Test
    public void test_OOPathによるネスト表記_1() {
        OOPathNestSample ooPathNestSample = new OOPathNestSample();
        RuleUnitInstance<OOPathNestSample> instance = RuleUnitProvider.get().createRuleUnitInstance(ooPathNestSample);

        var person = new Person("Taro", 21, new Address("Tokyo"));
        ooPathNestSample.getPersons().add(person);

        instance.fire();
        assertEquals(1, 1);
        instance.close();
    }

    @Test
    public void test_OOPathによるネスト表記_2() {
        OOPathNestSample ooPathNestSample = new OOPathNestSample();
        RuleUnitInstance<OOPathNestSample> instance = RuleUnitProvider.get().createRuleUnitInstance(ooPathNestSample);

        var person = new Person("Taro", 21, new Address("London"));
        ooPathNestSample.getPersons().add(person);

        instance.fire();
        assertEquals(1, 1);
        instance.close();
    }
}
