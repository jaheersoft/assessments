package com.workouts.problems.algorithms;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {10, 9, 7, 6, 3, 4, 2, 5 , 1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    //concept - select small element in an iteration and swapping with the first index element
    //          and start with second element for next iteration
    //Time Complexity - O(n2) -> for all cases
    //Space Complexity - O(1)
    //unstable sort
    public static int[] sort(int[] input) {
        for(int i=0;i<input.length;i++) {
            int minIndex = i;
            for(int j=i+1;j<input.length;j++) {
                if(input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;
        }
        return input;
    }
}
