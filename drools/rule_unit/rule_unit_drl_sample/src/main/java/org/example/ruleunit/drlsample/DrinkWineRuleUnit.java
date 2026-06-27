package org.example.ruleunit.drlsample;

import java.util.ArrayList;
import java.util.List;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStream;
import org.drools.ruleunits.api.RuleUnitData;

public class DrinkWineRuleUnit implements RuleUnitData {
    
    private DataStream<Person> persons = DataSource.createStream();;

    private List<Drink> drinkList = new ArrayList<>();


    public DataStream<Person> getPersons() {
        return persons;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }
}
