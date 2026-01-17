package org.example.agendagroup;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    // これまで実行されたルール名のリスト
    private List<String> executedRules = new ArrayList<>();

    // 最後に実行されたルール名
    private String latestRule = "";

    public void addRuleName(String ruleName) {
        this.executedRules.add(ruleName);
    }

    public List<String> getExecutedRules() {
        return executedRules;
    }
    
    public void setLatestRule(String ruleName) {
        this.latestRule = ruleName;
    }

    public String getLatestRule() {
        return latestRule;
    }

    @Override
    public String toString() {
        return this.executedRules.toString();
    }
}
