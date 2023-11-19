package org.example.droolsmetricsample;

import org.drools.ruleunits.api.DataStream;
import org.drools.ruleunits.api.RuleUnitData;

public class HighPerformanceRuleUnit implements RuleUnitData {
    
    private DataStream<Person> persons;

    private DataStream<Order> orders;

    public HighPerformanceRuleUnit() {}

    public HighPerformanceRuleUnit(DataStream<Person> persons) {
        this.persons = persons;
    }

    public void setPersons(DataStream<Person> persons) {
        this.persons = persons;
    }

    public DataStream<Person> getPersons() {
        return persons;
    }

    public void setOrders(DataStream<Order> orders) {
        this.orders = orders;
    }

    public DataStream<Order> getOrders() {
        return orders;
    }
   
}
