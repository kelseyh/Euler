package com.codefusion.euler;

public class PrimeFactorizer {

    public long calculateMaxPrimeFactor(long subject){
        for (long i = 2; i < Math.ceil(Math.sqrt(subject)); i += (i == 2 ? 1 : 2)){
            while (subject % i == 0){
                subject /= i;
                if (subject == 1){
                    return i;
                }
            }
        }
        return subject;
    }
}
