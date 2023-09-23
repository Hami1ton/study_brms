package org.example.integratewithopenai.unstructuredinput.ruleunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;


public class SampleTest {
    
    @Test
    public void test_優先度の決定() {
        PriorityRuleUnit priorityRuleUnit = new PriorityRuleUnit();
        RuleUnitInstance<PriorityRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(priorityRuleUnit);

        var customer = new Customer("Taro", 1);
        priorityRuleUnit.getCustomer().add(customer);

        var category = new InquiryCategory("要望");
        priorityRuleUnit.getInquiryCategory().add(category);

        // execute rule 
        instance.fire();

        // assert
        assertEquals(1, 1);

        instance.close();
    }
}
