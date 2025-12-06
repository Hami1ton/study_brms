package org.example.agendagroup;

import java.util.ArrayList;

public class SampleData {

    private ArrayList<String> executedRules = new ArrayList<>();

    private String latestRule = "";

    public void addRuleName(String ruleName) {
        this.executedRules.add(ruleName);
        this.latestRule = ruleName;
    }

    public ArrayList<String> getExecutedRules(String ruleName) {
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
