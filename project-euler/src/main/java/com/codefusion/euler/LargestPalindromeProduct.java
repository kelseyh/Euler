package com.codefusion.euler;

/**
 * Solution for Project Euler problem 4.
 */
public class LargestPalindromeProduct {

    public int calculate(int multiplier, int multiplicand){
        int maxPalindrome = 0;
        for(int i = multiplier; i > 0; i--){
            for(int j = multiplicand; j > 0; j--){
                int product = i * j;
                if (product < maxPalindrome){
                    break;
                }
                if (isPalindrome(product)){
                    maxPalindrome = product;
                }
            }
        }
        return maxPalindrome;
    }

    private boolean isPalindrome(int palindrome){
        char[] digits = String.valueOf(palindrome).toCharArray();
        int left = 0;
        int right = digits.length - 1;
        while(left < right){
            if (digits[left] != digits[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
