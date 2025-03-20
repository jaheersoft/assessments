package com.workouts.problems.algorithms;

import java.util.Arrays;

/*
Given an array of sorted numbers and a target sum,
find a pair in the array whose sum is equal to the given target
*/
public class PairSumSorted {
    public static void main(String[] arg) {
        int[] input = {1,1,1};
        System.out.println(Arrays.toString(bruteForce(input, 2)));
        System.out.println(Arrays.toString(twoPointer(input, 2)));
    }

    //Time complexity - O(n2) - O of nsquare
    //Space complexity - O(1)
    public static int[] bruteForce(int[] input,int target) {
        for(int i = 0;i < input.length;i++) {
           for(int j = i+1;j < input.length;j++) {
               int sum = input[i] + input[j];
               if(sum == target) {
                   return new int[]{i,j};
               }
           }
        }
        return new int[]{};
    }

    //Time complexity - O(n)
    //Space complexity - O(1)
    public static int[] twoPointer(int[] input,int target) {
        int left = 0;
        int right = input.length - 1;
        while(left < right) {
            int sum = input[left] + input[right];
            if(sum == target) {
                return new int[]{left,right};
            }
            if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
