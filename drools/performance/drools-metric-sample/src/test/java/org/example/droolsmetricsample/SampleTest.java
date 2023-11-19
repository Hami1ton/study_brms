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

            for (int j = 0; j < NUM_ORDER_PER_PERSON; j++) {
                int id = (i * NUM_ORDER_PER_PERSON) + j;
                int price = 1000;
                var order = new Order(id, person, LocalDate.parse("2023-11-10"), "Item" + j, price);    
                drinkRuleUnit.getOrders().append(order);
            }
        }
        drinkRuleUnit.getPointsPromotions().append(new PointsPromotion("10 points"
            , LocalDate.parse("2023-11-01")
            , LocalDate.parse("2023-11-09")
            , 10));

        // execute rule 
        instance.fire();

        // assert
        assertEquals("Beer", "Beer");

        instance.close();
    }

    // @Test
    // public void test_high_performance_constrains() {
    //     // drools-metric settings
    //     System.setProperty("drools.metric.logger.enabled", "true");
    //     System.setProperty("drools.metric.logger.threshold", "1");
        
    //     LowPerformanceRuleUnit drinkRuleUnit = new LowPerformanceRuleUnit();
    //     RuleUnitInstance<LowPerformanceRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(drinkRuleUnit);

    //     // insert fact
    //     for (int i = 0; i < NUM_PERSON; i++) {
    //         var person = new Person("Person" + i, i + 10);
    //         drinkRuleUnit.getPersons().append(person);

    //         for (int j = 0; j < NUM_ORDER_PER_PERSON; j++) {
    //             int id = (i * NUM_ORDER_PER_PERSON) + j;
    //             int price = j * 10;
    //             var order = new Order(id, person, "Item" + j, price);    
    //             drinkRuleUnit.getOrders().append(order);
    //         }
    //     }

    //     // execute rule 
    //     instance.fire();

    //     // assert
    //     assertEquals("Beer", "Beer");

    //     instance.close();
    // }
}
