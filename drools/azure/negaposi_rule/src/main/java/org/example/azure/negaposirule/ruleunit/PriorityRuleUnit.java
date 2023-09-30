package org.example.azure.negaposirule.ruleunit;

import org.drools.ruleunits.api.DataStream;
import org.drools.ruleunits.api.RuleUnitData;
import org.drools.ruleunits.api.SingletonStore;


public class PriorityRuleUnit implements RuleUnitData {
    
    private DataStream<Customer> customer;

    private DataStream<AnalyzedReviewComment> analyzedReviewComment;

    private SingletonStore<Priority> priority;

    public void setCustomer(DataStream<Customer> customer) {
        this.customer = customer;
    }

    public DataStream<Customer> getCustomer() {
        return customer;
    }

    public void setAnalyzedReviewComment(DataStream<AnalyzedReviewComment> analyzedReviewComment) {
        this.analyzedReviewComment = analyzedReviewComment;
    }

    public DataStream<AnalyzedReviewComment> getAnalyzedReviewComment() {
        return analyzedReviewComment;
    }

    public void setPriority(SingletonStore<Priority> priority) {
        this.priority = priority;
    }

    public SingletonStore<Priority> getPriority() {
        return priority;
    }

}
