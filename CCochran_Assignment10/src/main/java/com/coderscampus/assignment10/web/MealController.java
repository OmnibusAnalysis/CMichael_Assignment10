package com.coderscampus.assignment10.web;


import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class MealController {

    @GetMapping("/mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(Optional<String> targetCalories,
                                                   Optional<String> diet,
                                                   Optional<String> exclusions) {
        RestTemplate rt = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
                .queryParam("timeFrame", "day")
                .queryParam("targetCalories", targetCalories.orElse(null))
                .queryParam("diet", diet.orElse(null))
                .queryParam("exclude", exclusions.orElse(null))
                .queryParam("apiKey", "9a15c24fd45f44079018ea7a6cef3eb3")
                .build()
                .toUri();

        return rt.getForEntity(uri, DayResponse.class);
    }

    @GetMapping("/mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(Optional<String> targetCalories,
                                                     Optional<String> diet,
                                                     Optional<String> exclusions) {
        RestTemplate rt = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
                .queryParam("timeFrame", "week")
                .queryParam("targetCalories", targetCalories.orElse(null))
                .queryParam("diet", diet.orElse(null))
                .queryParam("exclude", exclusions.orElse(null))
                .queryParam("apiKey","9a15c24fd45f44079018ea7a6cef3eb3")
                .build()
                .toUri();

        return rt.getForEntity(uri, WeekResponse.class);

    }
}
