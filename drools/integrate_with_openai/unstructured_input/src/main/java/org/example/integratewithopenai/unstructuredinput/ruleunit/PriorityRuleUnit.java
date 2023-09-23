package org.example.integratewithopenai.unstructuredinput.ruleunit;

import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;


public class PriorityRuleUnit implements RuleUnitData {
    
    private DataStore<Customer> customer;

    private DataStore<InquiryCategory> inquiryCategory;

    private Priority priority = new Priority(0);

    public void setCustomer(DataStore<Customer> customer) {
        this.customer = customer;
    }

    public DataStore<Customer> getCustomer() {
        return customer;
    }

    public void setInquiryCategory(DataStore<InquiryCategory> inquiryCategory) {
        this.inquiryCategory = inquiryCategory;
    }

    public DataStore<InquiryCategory> getInquiryCategory() {
        return inquiryCategory;
    }

    public Priority getPriority() {
        return priority;
    }
   
}
