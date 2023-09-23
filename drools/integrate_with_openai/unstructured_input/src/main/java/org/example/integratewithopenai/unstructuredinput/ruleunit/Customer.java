package org.example.integratewithopenai.unstructuredinput.ruleunit;


public class Customer {

    private String name;

    private int contractPeriod;

    public Customer(String name, int contractPeriod) {
        this.name = name;
        this.contractPeriod = contractPeriod;
    }

    public String getName(){
        return name;
    }

    public int getContractPeriod(){
        return contractPeriod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContractPeriod(int contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    @Override
    public String toString() {
        return "name: " + name + ", " + "contractPeriod: " + contractPeriod;
    }

}