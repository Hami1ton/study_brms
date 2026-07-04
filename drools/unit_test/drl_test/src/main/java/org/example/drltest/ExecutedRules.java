package org.example.drltest;

import java.util.HashSet;
import java.util.Set;

public class ExecutedRules {
    // これまで実行されたルール名のリスト
    private Set<String> result = new HashSet<>();

    public void recordRuleName(String ruleName) {
        this.result.add(ruleName);
    }

    public Set<String> getExecutedRules() {
        return result;
    }
    
    @Override
    public String toString() {
        return this.result.toString();
    }
}
