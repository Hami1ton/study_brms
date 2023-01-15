package com.example;

public class Drink {

    private String name;

    private int charge;

    public String getName() {
        return name;
    }

    public int getCharge(){
        return charge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharge(int charge){
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "name: " + name + ", " + "charge: " + charge;
    }

}
