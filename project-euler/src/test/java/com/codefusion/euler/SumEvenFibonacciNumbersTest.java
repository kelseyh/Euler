package com.codefusion.euler;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
@RunWith(JUnitParamsRunner.class)
public class SumEvenFibonacciNumbersTest {
    private SumEvenFibonacciNumbers sumEvenFibonacciNumbers = new SumEvenFibonacciNumbers();

    @Test
    @Parameters({"90, 44",
                 "4000000, 4613732"})
    public void testSumEvenNumbers(int max, long expectedSum){
        assertEquals(expectedSum, sumEvenFibonacciNumbers.sumEvenNumbers(max));
    }
}