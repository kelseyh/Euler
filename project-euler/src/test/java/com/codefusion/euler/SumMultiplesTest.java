package com.codefusion.euler;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SumMultiplesTest {
    private SumMultiples sumMultiples = new SumMultiples();
    @Test
    @Parameters(method = "generateParams")
    public void testSumMultiples(int upToExclusive, int[] multiplesOf, long expectedSum){
        assertEquals(expectedSum, sumMultiples.calculate(upToExclusive, multiplesOf));
    }

    private Object[] generateParams(){
        return $(
                        calcExpected(10, 3),
                        calcExpected(15, 2),
                        calcExpected(8, 2),
                        calcExpected(10, 3, 5),
                        calcExpected(1000000000, 3),
                        calcExpected(1000000000, 5),
                        calcExpected(1000000000, 4),
                        calcExpected(1000000000, 3, 5),
                        calcExpected(120, 3, 5, 7)
        );
    }

    public void crudeBench(){
        int max = 1_000_000;
        int runs = 10_000;
        for (int i = 0; i < runs; i++) {
            calcExpected(max, 3, 5);
            sumMultiples.calculate(max, 3, 5);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < runs; i++) {
            calcExpected(max, 3, 5);
        }
        long bruteForceTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < runs; i++) {
            sumMultiples.calculate(max, 3, 5);
        }

        long algebraicTime = System.currentTimeMillis() - start;
        System.err.println("algebraic: "+ algebraicTime + ", bruteForce: "+bruteForceTime);
    }

    private Object[] calcExpected(int max, int ... multiplesOf){
        long result = 0;
        for (int i = 1; i < max; i++) {
            boolean isMultipleOf = false;
            for (int j = 0; j < multiplesOf.length; j++) {
                if (i % multiplesOf[j] == 0){
                    isMultipleOf = true;
                    break;
                }
            }
            if (isMultipleOf){
                result += i;
            }
        }
        return $(max, multiplesOf.clone(), result);
    }
}