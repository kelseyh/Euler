package com.codefusion.euler;

/**
 * Solution for Project Euler problem 2.
 */
public class SumEvenFibonacciNumbers {

    public long sumEvenNumbers(int max){
        long sum = 0;
        for(int curr = 0, next = 1, fib = 1; fib < max; fib = curr + next){
            curr = next;
            next = fib;
            if (isEvenNumber(fib)){
                sum += fib;
            }
        }
        return sum;
    }

    private boolean isEvenNumber(int number){
        return number % 2 == 0;
    }
}
