package com.streams.iterating;

import com.util.MockData;
import com.util.Person;

import java.util.List;
import java.util.stream.IntStream;

public class IteratingWithStreams {

    private static void range(){
        IntStream.rangeClosed(1, 10)
                .forEach(System.out::println);
    }

    private static void rangeIteratingList(){
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .forEach(i -> System.out.println(people.get(i)));
    }

    private static void intStreamIterate(){
        IntStream.iterate(0, operand -> operand + 1)
                .filter(number -> number % 2 == 0)
                .limit(100)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
//        range();
//        rangeIteratingList();
        intStreamIterate();
    }
}
