package com.streams.filtertrans;

import com.util.MockData;
import com.util.Person;
import com.util.PersonDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FilteringTransformingDemo {

    private static void basicFiltering(){
        List<Person> persons = MockData.getPeople();
        List<Person> p81above = persons.stream()
                .filter(p -> p.getAge() > 81)
                .collect(Collectors.toList());

        p81above.forEach(System.out::println);
        System.out.println("TOTAL ABOVE 81 years: "
                + p81above.size() + " out of " + persons.size());
    }

    private static void firstTransformation(){

        MockData.getPeople().stream()
                .limit(10)
                .map(PersonDTO::map)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
    

    public static void main(String[] args) {

//        basicFiltering();
        firstTransformation();
    }
}
