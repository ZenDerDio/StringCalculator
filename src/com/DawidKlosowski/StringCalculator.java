package com.DawidKlosowski;

import java.util.Arrays;
import java.util.regex.Pattern;
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
        if(values.isEmpty()) {
            return IntStream.empty();
        }else{
            return Stream.of(values.split(delimiter))
                        .mapToInt(Integer::parseInt)
                        .map(n->n %1000);
        }
    }

    private int finalSum(){
        catchNegatives();
        return numbersStream().sum();
    }

    public static int add(String numbers){
        return definedDelimiter(numbers).finalSum();
    }

    public void catchNegatives(){
        String collectionNegatives = numbersStream().filter(n->n<0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
                //adding numbers back into string to show them in exception message
        if(!collectionNegatives.isEmpty()){
            throw new IllegalArgumentException("Negatives not allowed: " + collectionNegatives);
        }
    }

    private static StringCalculator definedDelimiter(String numbers){
        if(numbers.startsWith("//")){
            String[] temporaryPieces = numbers.split("\n",2);
            return new StringCalculator(temporaryPieces[1],parseDelimiter(temporaryPieces[0]));
        }else{
            return new StringCalculator(numbers,",|\n");
        }
    }

    private static String parseDelimiter(String input){
        //allows to use special regex signs as delimiters
        String delimiter=input.substring(2);
        if(delimiter.startsWith("[")) {
            delimiter = delimiter.substring(1, delimiter.length() - 1);
        }
        return Stream.of(delimiter.split("]\\["))
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
