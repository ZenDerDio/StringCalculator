package com.DawidKlosowski;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

    private String values;
    private String delimiter;

    private StringCalculator(String values, String delimiter) {
        this.values = values;
        this.delimiter = delimiter;
    }

    public static int add(String numbers){
        if(numbers.isEmpty())
            return 0;

        StringCalculator calculator;

        if(numbers.startsWith("//")){
            String[] parts = numbers.split("\n",2);
            calculator = new StringCalculator(parts[1],parts[0].substring(2));
        }else{
            calculator = new StringCalculator(numbers,",|\n");
        }

        Stream<String> sumStream = Arrays.stream(calculator.values.split(calculator.delimiter));
        return sumStream.mapToInt(Integer::parseInt).sum();

    }
}
