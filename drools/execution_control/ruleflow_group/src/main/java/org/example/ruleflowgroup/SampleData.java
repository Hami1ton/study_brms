package org.example.ruleflowgroup;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    private List<String> executedRules = new ArrayList<>();

    private String latestRule = "";

    public void addRuleName(String ruleName) {
        this.executedRules.add(ruleName);
        this.latestRule = ruleName;
    }

    public List<String> getExecutedRules() {
        return executedRules;
    }

    public String getLatestRule() {
        return latestRule;
    }

    @Override
    public String toString() {
        return this.executedRules.toString();
    }
}
