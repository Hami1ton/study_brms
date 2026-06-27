package org.example.ruleunit.drlsample;

public class Drink {

    private String name;

    public Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }

}