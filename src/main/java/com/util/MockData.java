package com.util;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MockData {

    private static List<Person> persons;

    static {
        Faker faker = new Faker();
        persons = new ArrayList<>();
        IntStream.range(0, 1000)
                .forEach(index -> persons.add(new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.address().fullAddress(),
                        faker.job().title(),
                        faker.number().numberBetween(18, 85),
                        faker.number().numberBetween(800, 4000)

                )));
    }

    public static List<Person> getPeople(){
        return persons;
    }

}
