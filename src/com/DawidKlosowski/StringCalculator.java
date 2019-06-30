package com.DawidKlosowski;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    private String values;
    private String delimiter;

    private StringCalculator(String values, String delimiter) {
        this.values = values;
        this.delimiter = delimiter;
    }

    private IntStream numbersStream(){
        return Arrays.stream(values.split(delimiter)).mapToInt(Integer::parseInt);
    }

    private int finalSum(){
        if(numbersStream().anyMatch(n -> n < 0)){
            throw new IllegalArgumentException("Negatives not allowed");
        }
        return numbersStream().sum();
    }

    public static int add(String numbers){
        if(numbers.isEmpty())
            return 0;

        return definedDelimiter(numbers).finalSum();
    }

    private static StringCalculator definedDelimiter(String numbers){
        if(numbers.startsWith("//")){
            String[] temporaryPieces = numbers.split("\n",2);
            return new StringCalculator(temporaryPieces[1],temporaryPieces[0].substring(2));
        }else{
            return new StringCalculator(numbers,",|\n");
        }
    }
}
