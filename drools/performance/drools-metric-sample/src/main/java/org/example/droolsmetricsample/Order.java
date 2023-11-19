package org.example.droolsmetricsample;

import java.time.LocalDate;

public record Order (
    int id,
    Person person,
    LocalDate orderDate,
    String itemName,
    int price
){}
