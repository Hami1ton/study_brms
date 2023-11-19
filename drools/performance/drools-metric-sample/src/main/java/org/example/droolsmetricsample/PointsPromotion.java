package org.example.droolsmetricsample;

import java.time.LocalDate;

public record PointsPromotion (
    String name,
    LocalDate startDate,
    LocalDate endDate,
    int points
){}
