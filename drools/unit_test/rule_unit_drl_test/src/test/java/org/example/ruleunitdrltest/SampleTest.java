package org.example.ruleunitdrltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleTest {

    static final Logger log = LoggerFactory.getLogger(SampleTest.class);

    @Test
    public void test_RuleUnitの動きをテスト() {

        SampleRuleUnit sampleRuleUnit = new SampleRuleUnit();
        RuleUnitInstance<SampleRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(sampleRuleUnit);
        var data = new SampleData();
        sampleRuleUnit.getSampleDatas().append(data);

        // execute rule 
        instance.fire();
        instance.close();

        // assert
        assertEquals(Arrays.asList("Rule_A", "Rule_A", "Rule_B", "Rule_C"), data.getExecutedRules());
        // assertEquals("Rule_A", data.getLatestRule());
    }
}
