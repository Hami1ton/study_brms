package org.example.ruleunit.drlsample;

import java.util.ArrayList;
import java.util.List;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class DrinkBeerRuleUnit implements RuleUnitData {
    
    // ルールの条件で参照するデータ定義(DataStoreを使用)    
    private DataStore<Person> persons;

    private List<Drink> drinkList = new ArrayList<>();

    public DrinkBeerRuleUnit() {
        this(DataSource.createStore());
    }

    public DrinkBeerRuleUnit(DataStore<Person> persons) {
        this.persons = persons;
    }

    public void setPersons(DataStore<Person> persons) {
        this.persons = persons;
    }

    public DataStore<Person> getPersons() {
        return persons;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }
   
}
