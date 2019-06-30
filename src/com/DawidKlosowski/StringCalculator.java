package com.DawidKlosowski;

import java.util.Arrays;
import java.util.stream.Collectors;
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
        return Stream.of(values.split(delimiter))
                .mapToInt(Integer::parseInt)
                .map(n->n %1000);
    }

    private int finalSum(){
        catchNegatives();
        return numbersStream().sum();
    }

    public static int add(String numbers){
        if(numbers.isEmpty())
            return 0;

        return definedDelimiter(numbers).finalSum();
    }
    public void catchNegatives(){
        String collectionNegatives = numbersStream().filter(n->n<0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));//adding numbers back into string to show exception message
        if(!collectionNegatives.isEmpty()){
            throw new IllegalArgumentException("Negatives not allowed: " + collectionNegatives);
        }
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
