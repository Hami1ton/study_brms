package org.example.azure.negaposirule.ruleunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;


public class PriorityRuleUnitTest {
    
    @Test
    public void test_優先度の決定_長期顧客_ポジティブ() {
        PriorityRuleUnit priorityRuleUnit = new PriorityRuleUnit();
        RuleUnitInstance<PriorityRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(priorityRuleUnit);

        var customer = new Customer("Taro", 5);
        priorityRuleUnit.getCustomer().append(customer);

        var comment = new AnalyzedReviewComment(
            "comment"
            , 0.3
            , 0.8
            , 0.9
        );
        priorityRuleUnit.getAnalyzedReviewComment().append(comment);

        // execute rule 
        instance.fire();

        // get result by query
        var queryResult = instance.executeQuery("FindPriority").toList().get(0);
        Priority priority = (Priority) queryResult.get("$p");
        instance.close();

        // assert
        assertEquals(2, priority.value());

        
    }

    @Test
    public void test_優先度の決定_短期顧客_ネガティブ() {
        PriorityRuleUnit priorityRuleUnit = new PriorityRuleUnit();
        RuleUnitInstance<PriorityRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(priorityRuleUnit);

        var customer = new Customer("Taro", 1);
        priorityRuleUnit.getCustomer().append(customer);

        var comment = new AnalyzedReviewComment(
            "comment"
            , 0.7
            , 0.8
            , 0.9
        );
        priorityRuleUnit.getAnalyzedReviewComment().append(comment);

        // execute rule 
        instance.fire();

        // get result by query
        var queryResult = instance.executeQuery("FindPriority").toList().get(0);
        Priority priority = (Priority) queryResult.get("$p");
        instance.close();

        // assert
        assertEquals(1, priority.value());
    }
}
