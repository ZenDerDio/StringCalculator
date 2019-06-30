package com.DawidKlosowski.test;

import com.DawidKlosowski.StringCalculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class StringCalculatorTest {

    @Test
    public void addEmptyString(){
            assertEquals(0,StringCalculator.add(""));
    }

    @Test
    public void addOneElementString(){
        assertEquals(9,StringCalculator.add("9"));
        assertEquals(27,StringCalculator.add("27"));
    }
    @Test
    public void addTwoNumbersWithCommaString(){
        assertEquals(12,StringCalculator.add("9,3"));
    }
    @Test
    public void addMultipleNumbersWithCommaString(){
        assertEquals(17,StringCalculator.add("9,3,1,4"));
    }
    @Test
    public void addMultipleNumbersNewLineSeparatorString(){
        assertEquals(5,StringCalculator.add("2\n3"));
    }
    @Test
    public void addMultipleNumbersNewLineCommaSeparatorString(){
        assertEquals(6,StringCalculator.add("1\n2,3"));
    }
    @Test
    public void addMultipleNumbersUserDefinedDelimiterString(){
        assertEquals(5,StringCalculator.add("//;\n2;3"));
    }



}