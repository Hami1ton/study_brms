package org.example.ruleunitdrltest;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStream;
import org.drools.ruleunits.api.RuleUnitData;

public class SampleRuleUnit implements RuleUnitData {
    
    private DataStream<SampleData> sampleDatas = DataSource.createStream();

    public DataStream<SampleData> getSampleDatas() {
        return sampleDatas;
    }
}
