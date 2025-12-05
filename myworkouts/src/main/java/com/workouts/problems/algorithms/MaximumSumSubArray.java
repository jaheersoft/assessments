package com.workouts.problems.algorithms;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] i = {2,9,31,-4,21,7};
        int k = 3;
        System.out.println(slidingWindow(i,k));
        System.out.println(dynamicProgramming(i));
    }

    /*
    You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

    The length of the subarray is k, and
    All the elements of the subarray are distinct.
    Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

    A subarray is a contiguous non-empty sequence of elements within an array.
     */
    public static int slidingWindow(int[] a,int k) {
        int wSum = 0;
        int mSum = Integer.MIN_VALUE;
        for(int i =0; i < k; i++) {
            wSum += a[i];
        }
        for(int i = k; i < a.length; i++) {
            wSum = wSum - a[i-k] + a[i];
            mSum = Math.max(mSum, wSum);
        }
        return mSum;
    }

    /*
    Given an integer array nums, find the subarray with the largest sum, and return its sum.
     */
    public static int dynamicProgramming(int[] a) {
        int maxSoFar = a[0];
        int currMax = a[0];
        for(int i =1; i < a.length; i++) {
            currMax = Math.max(a[i], a[i]+currMax);
            maxSoFar = Math.max(currMax,maxSoFar);
        }
        return maxSoFar;
    }
}
