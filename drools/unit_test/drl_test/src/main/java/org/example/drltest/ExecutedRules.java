package org.example.drltest;

import java.util.ArrayList;
import java.util.List;

public class ExecutedRules {
    // これまで実行されたルール名のリスト
    private List<String> result = new ArrayList<>();

    public void recordRuleName(String ruleName) {
        this.result.add(ruleName);
    }

    public List<String> getExecutedRules() {
        return result;
    }
    
    @Override
    public String toString() {
        return this.result.toString();
    }
}
