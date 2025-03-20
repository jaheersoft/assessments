package com.workouts.problems.algorithms;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class Palindrome {

    public static void main(String[] args) {
        String input = "racecar";
        System.out.println(isValidPalindromeTwoPointerApproach(input));
    }

    //Time complexity - O(n)
    //Space complexity - O(1)
    public static boolean isValidPalindromeTwoPointerApproach(String input) {
        int left = 0;
        int right = input.length() - 1;
        int median = input.length() / 2;
        char midValue = 0;
        if(input.length() % 2 == 1) {
             midValue = input.charAt(median);
        }
        while(left < right) {
            if(input.charAt(left) == midValue || input.charAt(right) == midValue) {
                return true;
            }
            if(!Character.isLetterOrDigit(input.charAt(left))) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(input.charAt(right))) {
                right--;
                continue;
            }
            if(input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
