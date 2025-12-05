package com.workouts.problems.algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {10, 9, 7, 6, 3, 4, 2, 5 , 1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    //concept -  treats the input as two parts, a tentatively sorted part, and an unsorted part,
    // and repeatedly inserts the next value from the unsorted part into the correct location in the sorted part
    //Every time you get an item, you insert it in the correct position. That’s why it’s called insertion sort - hybrid sorting techniques
    //Time Complexity - O(n2) -> for worst cases, best case - O(n)
    //Space Complexity - O(1)
    //Stable sort
    public static int[] sort(int[] input) {
        for(int i=1;i<input.length;i++) {
            for(int j=i;j>0;j--) {
                if(input[j] < input[j-1]) {
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                } else
                    break;
            }
        }
        return input;
    }
}
