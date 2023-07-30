package org.example.ruleunit.drlsample;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class DrinkRuleUnit implements RuleUnitData {
    
    private DataStore<Person> persons;

    private DataStore<Drink> drinks;

    public DrinkRuleUnit() {
        this(DataSource.createStore(), DataSource.createStore());
    }

    public DrinkRuleUnit(DataStore<Person> persons, DataStore<Drink> drinks) {
        this.persons = persons;
        this.drinks = drinks;
    }

    public void setPersons(DataStore<Person> persons) {
        this.persons = persons;
    }

    public DataStore<Person> getPersons() {
        return persons;
    }

    public void setDrinks(DataStore<Drink> drinks) {
        this.drinks = drinks;
    }

    public DataStore<Drink> getDrinks() {
        return drinks;
    }
   
}
