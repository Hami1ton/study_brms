package org.example.integratewithopenai.unstructuredinput.ruleunit;


public class Priority {

    private int value;

    public Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Priority: " + value;
    }

}