package org.example.droolsmetricsample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.jupiter.api.Test;

public class SampleTest {

    private final int NUM_PERSON = 10;
    private final int NUM_ORDER_PER_PERSON = 100;
    
    @Test
    public void test_low_performance_constrains() {
        // drools-metric settings
        System.setProperty("drools.metric.logger.enabled", "true");
        System.setProperty("drools.metric.logger.threshold", "1");
        
        LowPerformanceRuleUnit drinkRuleUnit = new LowPerformanceRuleUnit();
        RuleUnitInstance<LowPerformanceRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(drinkRuleUnit);

        // insert fact
        for (int i = 0; i < NUM_PERSON; i++) {
            var person = new Person("Person" + i, i + 10);
            drinkRuleUnit.getPersons().append(person);
            var orderDate = LocalDate.parse("2023-01-01").plusMonths(i);

            for (int j = 0; j < NUM_ORDER_PER_PERSON; j++) {
                int id = (i * NUM_ORDER_PER_PERSON) + j;
                var order = new Order(id, person, orderDate, "Item" + j, 1000);    
                drinkRuleUnit.getOrders().append(order);
            }
        }
        drinkRuleUnit.getPointsPromotions().append(new PointsPromotion("10 points"
            , LocalDate.parse("2023-10-01")
            , LocalDate.parse("2023-10-09")
            , 10));

        // execute rule
        int count = instance.fire();
        instance.close();

        // assert
        assertEquals(100, count);
    }

    @Test
    public void test_high_performance_constrains() {
        // drools-metric settings
        System.setProperty("drools.metric.logger.enabled", "true");
        System.setProperty("drools.metric.logger.threshold", "1");
        
        HighPerformanceRuleUnit drinkRuleUnit = new HighPerformanceRuleUnit();
        RuleUnitInstance<HighPerformanceRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(drinkRuleUnit);

        // insert fact
        for (int i = 0; i < NUM_PERSON; i++) {
            var person = new Person("Person" + i, i + 10);
            drinkRuleUnit.getPersons().append(person);
            var orderDate = LocalDate.parse("2023-01-01").plusMonths(i);

            for (int j = 0; j < NUM_ORDER_PER_PERSON; j++) {
                int id = (i * NUM_ORDER_PER_PERSON) + j;
                var order = new Order(id, person, orderDate, "Item" + j, 1000);    
                drinkRuleUnit.getOrders().append(order);
            }
        }
        drinkRuleUnit.getPointsPromotions().append(new PointsPromotion("10 points"
            , LocalDate.parse("2023-10-01")
            , LocalDate.parse("2023-10-09")
            , 10));

        // execute rule
        int count = instance.fire();
        instance.close();

        // assert
        assertEquals(100, count);
    }


}
