package org.example.droolsmetricsample;

public record Order (
    int id,
    Person person,
    String itemName,
    int price
){}
