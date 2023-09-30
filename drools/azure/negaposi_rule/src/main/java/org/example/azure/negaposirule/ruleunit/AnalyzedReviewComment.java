package org.example.azure.negaposirule.ruleunit;

import java.util.HashMap;

public record AnalyzedReviewComment(
    String comment
    , double negative
    , double neutral
    , double positive) {

    public String sentiment() {
        var sentimentMap = new HashMap<String, Double>();
        sentimentMap.put("negative", this.negative);
        sentimentMap.put("neutral", this.neutral);
        sentimentMap.put("positive", this.positive);

        String maxKey = sentimentMap.entrySet().stream()
            .max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
            .get()
            .getKey();

        return maxKey;
    }

}
