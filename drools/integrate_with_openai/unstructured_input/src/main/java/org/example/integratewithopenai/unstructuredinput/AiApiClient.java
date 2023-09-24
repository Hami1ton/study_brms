package org.example.integratewithopenai.unstructuredinput;

import java.util.ResourceBundle;

import org.example.integratewithopenai.unstructuredinput.ruleunit.InquiryCategory;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class AiApiClient {

    public InquiryCategory decideCategory(String prompt) {

        // get token from env
        String token = System.getenv("OPENAI_TOKEN");
        OpenAiService service = new OpenAiService(token);        

        CompletionRequest completionRequest = CompletionRequest.builder()
            .prompt(prompt)
            .model("gpt-3.5-turbo")
            .echo(true)
            .maxTokens(10)
            .temperature(0.0)
            .build();

        CompletionChoice choice = service.createCompletion(completionRequest).getChoices().get(0);
        System.out.println(choice.getText());

        return new InquiryCategory(choice.getText());
    }
    
}
