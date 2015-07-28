package com.codefusion.euler;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
@RunWith(JUnitParamsRunner.class)
public class LargestPalindromeProductTest {
    private LargestPalindromeProduct largestPalindromeProduct = new LargestPalindromeProduct();
    @Parameters({"91, 99, 9009",
                 "999, 999, 906609"})
    @Test
    public void testCalculate(int multipler, int multipliand, int expectedPalindrome) throws Exception {
        assertEquals(expectedPalindrome, largestPalindromeProduct.calculate(multipler, multipliand));
    }
}