package com.streams.minmax;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMaxExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,33,2,100,99,4);

        System.out.println(numbers.stream()
                .max(Comparator.naturalOrder())
                .get()

        );
    }
}
