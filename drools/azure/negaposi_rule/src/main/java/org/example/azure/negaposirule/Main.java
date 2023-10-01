package org.example.azure.negaposirule;

import org.example.azure.negaposirule.ruleunit.AnalyzedReviewComment;
import org.example.azure.negaposirule.ruleunit.Customer;


public class Main {

    public static void main(String[] args) {
        var customer = new Customer("Taro", 2);

       // call API to analyze comment
        String reviewComment = "UIが少しわかりづらいです。" ;
        AiApiClient ac = new AiApiClient();
        AnalyzedReviewComment analyzedReviewComment = ac.analyzeComment(reviewComment);
    
        // decide the priority 
        DecisionService ds = new DecisionService();
        var priority = ds.decidePriority(customer, analyzedReviewComment);

        System.out.println(priority);
    }
}
