package org.example.integratewithopenai.unstructuredinput;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.example.integratewithopenai.unstructuredinput.ruleunit.Customer;
import org.example.integratewithopenai.unstructuredinput.ruleunit.InquiryCategory;
import org.example.integratewithopenai.unstructuredinput.ruleunit.Priority;
import org.example.integratewithopenai.unstructuredinput.ruleunit.PriorityRuleUnit;

public class DecisionService {

    public Priority decidePriority(Customer customer, InquiryCategory category) {
        PriorityRuleUnit priorityRuleUnit = new PriorityRuleUnit();
        RuleUnitInstance<PriorityRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(priorityRuleUnit);

        priorityRuleUnit.getCustomer().append(customer);
        priorityRuleUnit.getInquiryCategory().append(category);

        // execute rule 
        instance.fire();

        // get result by query
        var queryResult = instance.executeQuery("FindPriority").toList();
        System.out.println(queryResult);
        // Priority priority = (Priority) queryResult.get("$p");

        instance.close();

        return null;
    }
    
}
