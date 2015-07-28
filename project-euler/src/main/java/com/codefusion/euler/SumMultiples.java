package com.codefusion.euler;
/**
 * Solution for Project Euler problem 1.
 */
public class SumMultiples {

    public long calculate(int exclusiveLimit, int... multiplesOf) {

        long sum = 0;
        long lessCommon = 0;
        --exclusiveLimit;
        if (exclusiveLimit == 0 && multiplesOf.length == 0) {
            return sum;
        }

        for (int i = 0; i < multiplesOf.length; i++) {
            sum += sumMultiplesOf(exclusiveLimit, multiplesOf[i]);
            for (int j = i - 1; j >= 0; j--) {
                lessCommon += sumMultiplesOf(exclusiveLimit, multiplesOf[i] * multiplesOf[j]);
            }
        }

        return sum - lessCommon;
    }

    /**
     * Sums the multiples up to the given limit using
     * Arithmetic progression using the formula
     * <p>
     * Sn = (n/2) * (a1 + an)
     * where
     * Sn = the sum of the terms in the sequence
     * n  = the number of terms in the sequence
     * a1 = the first term in the sequence
     * an = the nth term in the sequence
     *
     * @param exclusiveLimit
     * @param multiplesOf
     * @return
     */
    private long sumMultiplesOf(int exclusiveLimit, int multiplesOf) {
        long a1 = multiplesOf;
        long n = exclusiveLimit / a1;
        long an = n * a1;

        long result = (long)((n / 2.0) * (a1 + an));
        return result;
    }
}