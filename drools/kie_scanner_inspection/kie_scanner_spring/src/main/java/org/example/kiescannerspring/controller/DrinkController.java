package org.example.kiescannerspring.controller;

import org.example.Drink;
import org.example.Person;
import org.example.kiescannerspring.service.DrinkDecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DrinkController {

    @Autowired
    DrinkDecisionService drinkDecisionService;


    @GetMapping("/drink")
    public Drink decideDrink(@ModelAttribute(name = "person") Person person) {

        Drink drink = drinkDecisionService.decideDrink(person);

        return drink;
    }
}
