package org.example.droolsmetricsample;

import org.drools.ruleunits.api.DataStream;
import org.drools.ruleunits.api.RuleUnitData;


public class HighPerformanceRuleUnit implements RuleUnitData {
    
    private DataStream<Person> persons;

    private DataStream<Order> orders;

    private DataStream<PointsPromotion> pointsPromotions;

    public HighPerformanceRuleUnit() {}

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

    
    public void setPointsPromotions(DataStream<PointsPromotion> pointsPromotions) {
        this.pointsPromotions = pointsPromotions;
    }

    public DataStream<PointsPromotion> getPointsPromotions() {
        return pointsPromotions;
    }

}
