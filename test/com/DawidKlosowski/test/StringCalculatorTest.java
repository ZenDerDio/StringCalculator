package com.DawidKlosowski.test;

import com.DawidKlosowski.StringCalculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addNegativeNumbersExceptionString(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed: -2");
        StringCalculator.add("-2");
    }

    @Test
    public void addNegativeMultipleNumbersExceptionString(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed: -5,-8,-14");
        StringCalculator.add("1,-5,-8,9,-14");
    }

    @Test
    public void addNumbersOver1000IgnoringThousandDigit(){
        assertEquals(6,StringCalculator.add("3,1003"));
    }

    @Test
    public void addMultipleCharDelimiter(){
        assertEquals(9,StringCalculator.add("//[****}\n2****3****4"));
    }

    @Test
    public void addMultipleDefinedDelimiters(){
        assertEquals(9,StringCalculator.add("//[^][;]\n2^3;4"));
    }

}