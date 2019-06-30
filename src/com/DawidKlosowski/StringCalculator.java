package com.DawidKlosowski;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }else{
            Stream<String> sumStream = Arrays.stream(numbers.split(",|\n"));
            return sumStream.mapToInt(Integer::parseInt).sum();
        }
    }
}
