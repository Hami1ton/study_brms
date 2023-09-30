package org.example.azure.negaposirule.ruleunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class AnalyzedReviewCommentTest {

    @Test
    public void test_ネガティブ() {
        var comment = new AnalyzedReviewComment(
            "comment"
            , 0.94
            , 0.8
            , 0.0
        );
        // assert
        assertEquals("negative", comment.sentiment());
    }

    @Test
    public void test_ニュートラル() {
        var comment = new AnalyzedReviewComment(
            "comment"
            , 0.1
            , 0.3
            , 0.2
        );
        // assert
        assertEquals("neutral", comment.sentiment());
    }

    @Test
    public void test_ポジティブ() {
        var comment = new AnalyzedReviewComment(
            "comment"
            , 0.1
            , 0.6
            , 0.65
        );
        // assert
        assertEquals("positive", comment.sentiment());
    }

}
