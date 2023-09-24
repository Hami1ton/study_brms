package org.example.integratewithopenai.unstructuredinput;

import org.example.integratewithopenai.unstructuredinput.ruleunit.Customer;
import org.example.integratewithopenai.unstructuredinput.ruleunit.InquiryCategory;

public class Main {

    public static void main(String[] args) {
        var customer = new Customer("Taro", 10);

        // build prompt
        StringBuilder sb = new StringBuilder("あなたはSaaS製品を手掛ける企業のカスタマーサービス担当です。これから私が送る文章を要望・質問・クレームのいずれかに分類してください。");
        sb.append("回答は、要望であれば「A」、質問であれば「B」、クレームであれば「C」とアルファベット1文字で回答してください。\n");
        sb.append("サービスのユーザ情報変更機能が使いづらいです。");
        String prompt = sb.toString();

        // call API to get the inquiry category
        AiApiClient ac = new AiApiClient();
        InquiryCategory category = ac.decideCategory(prompt);
    
        // decide the priority 
        DecisionService ds = new DecisionService();
        var priority = ds.decidePriority(customer, category);

        System.out.println(priority);

    }
    
}
