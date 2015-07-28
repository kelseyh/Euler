package com.codefusion.euler;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
@RunWith(JUnitParamsRunner.class)
public class PrimeFactorizerTest {
    private PrimeFactorizer primeFactorizer = new PrimeFactorizer();
    @Test
    @Parameters({"7, 7",
                 "42, 7",
                 "12, 3",
                 "21, 7",
                 "28, 7",
                 "13195, 29",
                 "531, 59"   ,
                 "600851475143, 6857",
                 "9008514751433278136, 1689945799"})
    public void testCalculateMaxPrimeFactor(long subject, long maxPrimeFactor) throws Exception {
        assertEquals(maxPrimeFactor, primeFactorizer.calculateMaxPrimeFactor(subject));
    }
}