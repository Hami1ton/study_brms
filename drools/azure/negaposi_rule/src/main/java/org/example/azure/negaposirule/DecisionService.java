package org.example.azure.negaposirule;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.example.azure.negaposirule.ruleunit.Customer;
import org.example.azure.negaposirule.ruleunit.InquiryCategory;
import org.example.azure.negaposirule.ruleunit.Priority;
import org.example.azure.negaposirule.ruleunit.PriorityRuleUnit;

public class DecisionService {

    public Priority decidePriority(Customer customer, InquiryCategory category) {
        PriorityRuleUnit priorityRuleUnit = new PriorityRuleUnit();
        RuleUnitInstance<PriorityRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(priorityRuleUnit);

        priorityRuleUnit.getCustomer().append(customer);
        priorityRuleUnit.getInquiryCategory().append(category);

        // execute rule 
        instance.fire();

        // get result by query
        Priority priority = null;
        var queryResult = instance.executeQuery("FindPriority").toList();
        if (queryResult.size() == 1) {
            priority = (Priority) queryResult.get(0).get("$p");
        }
        instance.close();

        return priority;
    }
    
}
