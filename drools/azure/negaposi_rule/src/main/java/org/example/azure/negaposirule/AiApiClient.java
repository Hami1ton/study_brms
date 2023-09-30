package org.example.azure.negaposirule;

import org.example.azure.negaposirule.ruleunit.AnalyzedReviewComment;
import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.core.credential.AzureKeyCredential;


public class AiApiClient {

    public AnalyzedReviewComment analyzeComment(String comment) {

        // get token from env
        String key = System.getenv("AZURE_CREDENTIAL_KEY");
        String endpoint = System.getenv("AZURE_ENDPOINT");

        // get token from env
        AzureKeyCredential credential = new AzureKeyCredential(key);
        TextAnalyticsClient textAnalyticsClient = new TextAnalyticsClientBuilder()
            .credential(credential)
            .endpoint(endpoint)
            .buildClient();

        DocumentSentiment documentSentiment = textAnalyticsClient.analyzeSentiment(comment);
        System.out.println("======Analyze comment======");
        System.out.println("negative:" + documentSentiment.getConfidenceScores().getNegative());
        System.out.println("neutral:" + documentSentiment.getConfidenceScores().getNeutral());
        System.out.println("positive:" + documentSentiment.getConfidenceScores().getPositive());
        System.out.println("===========================");
         
        return new AnalyzedReviewComment(
                comment
                , documentSentiment.getConfidenceScores().getNegative()
                , documentSentiment.getConfidenceScores().getNeutral()
                , documentSentiment.getConfidenceScores().getPositive()
            );
    }
    
}
