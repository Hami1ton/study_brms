package org.example.integratewithopenai.unstructuredinput.ruleunit;

public class InquiryCategory {

    private String value;

    public InquiryCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "InquiryCategory: " + value;
    }

}
