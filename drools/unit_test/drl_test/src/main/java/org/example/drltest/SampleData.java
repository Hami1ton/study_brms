package org.example.drltest;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    // これまで実行されたルール名のリスト
    private List<String> executedRules = new ArrayList<>();

    public void addRuleName(String ruleName) {
        this.executedRules.add(ruleName);
    }

    public List<String> getExecutedRules() {
        return executedRules;
    }
    
    @Override
    public String toString() {
        return this.executedRules.toString();
    }
}
