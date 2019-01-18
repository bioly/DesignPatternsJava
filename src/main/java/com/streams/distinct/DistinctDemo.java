package com.streams.distinct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,1,2,2,3,3,3,4,4,5,5,6,6,7,7,7,8,9);

        System.out.println(
                numbers.stream()
                    .distinct()
                    .collect(Collectors.toList())
        );

        // other method - taking opportunity of set properties

        System.out.println(
                numbers.stream()
                    .collect(Collectors.toSet())
        );

    }
}
