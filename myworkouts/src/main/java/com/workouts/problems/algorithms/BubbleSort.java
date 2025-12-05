package com.workouts.problems.algorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {10, 9, 7, 6, 3, 4, 2, 5 , 1};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    //concept -  compares two adjacent elements then swapping and last element is bubbled out as it will high after one full innner for loop execution
    //time comp - O(n2) best case - O(n)
    //Space comp - O(1)
    //stable sort
    public static int[] bubbleSort(int[] input) {
        int currLength = input.length;
        while(currLength > 1) {
            boolean swapped = false;
            for(int j = 0;j < currLength-1;j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
            currLength--;
        }
        return input;
    }
}
