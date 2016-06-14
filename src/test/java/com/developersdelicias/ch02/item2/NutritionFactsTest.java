package com.developersdelicias.ch02.item2;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class NutritionFactsTest {

    @Test
    public void should_create_nutrition_fact_object_using_builder_pattern() throws Exception {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        assertNotNull(cocaCola);
    }
}