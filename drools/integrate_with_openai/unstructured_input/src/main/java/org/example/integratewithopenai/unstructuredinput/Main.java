package org.example.integratewithopenai.unstructuredinput;

import org.example.integratewithopenai.unstructuredinput.ruleunit.Customer;
import org.example.integratewithopenai.unstructuredinput.ruleunit.InquiryCategory;

public class Main {

    public static void main(String[] args) {

        // call API to get the inquiry category
    
        // decide the priority 
        DecisionService ds = new DecisionService();
        var customer = new Customer("Taro", 1);
        var category = new InquiryCategory("要望");
        ds.decidePriority(customer, category);


    }
    
}
