package com.workouts.problems.algorithms;

import java.util.Arrays;

public class TripletSumUnsorted {

    public static void main(String[] args) {
        int[] input = {1, 4, 45, 6, 10, 8,2};
        //System.out.println(Arrays.toString(bruteForce(input, 3)));
        System.out.println(Arrays.toString(twoPointer(input, 13)));
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
    public static int[] pairSum(int[] input,int start,int target) {
        int left = start;
        int right = input.length - 1;
        int[] output = {};
        while(left < right) {
            int sum = input[left] + input[right];
            System.out.println("sum ==="+sum);
            System.out.println("target ==="+target);
            if(sum == target) {
                if(output.length == 0) {
                    output = new int[]{input[left],input[right]};
                } else {
                    output = Arrays.copyOf(output, output.length + 2);
                    output[output.length-2] = input[left];
                    output[output.length-1] = input[right];
                }
            }
            if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return output;
    }

    public static int[] twoPointer(int[] input,int target) {
        Arrays.sort(input); //after sorting [1, 2, 4, 6, 8, 10, 45]
        System.out.println(Arrays.toString(input));
        for(int i = 0; i < input.length; i++) {
            if(i+1 < input.length) {
                int curTarget = target - input[i]; //13
                System.out.println(curTarget);
                int[] curOutput = pairSum(input,i + 1,curTarget);
                System.out.println(Arrays.toString(curOutput));
                for(int j = 0;j < curOutput.length;j=j+2) {
                    int[] output = Arrays.copyOf(curOutput,curOutput.length+1);
                    output[2] = input[i];
                    System.out.println(Arrays.toString(output));
                }
            }
        }
        return new int[]{};
    }
}
