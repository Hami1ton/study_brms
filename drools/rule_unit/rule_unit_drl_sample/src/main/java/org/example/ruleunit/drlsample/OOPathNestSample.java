package org.example.ruleunit.drlsample;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class OOPathNestSample implements RuleUnitData {
    
    private DataStore<Person> persons;

    public OOPathNestSample() {
        this(DataSource.createStore());
    }

    public OOPathNestSample(DataStore<Person> persons) {
        this.persons = persons;
    }

    public void setPersons(DataStore<Person> persons) {
        this.persons = persons;
    }

    public DataStore<Person> getPersons() {
        return persons;
    }
  
}
