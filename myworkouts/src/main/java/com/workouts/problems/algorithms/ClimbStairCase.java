package com.workouts.problems.algorithms;

//Determine the number of distinct ways to climb a staircase of n steps by taking either 1 or
//2 steps at a time.
public class ClimbStairCase {

    public static void main(String[] args) {
        int[] memoizationForNoOfSteps = new int[5];

    }

    public static int usingRecursion(int noOfSteps) {

        return 0;
    }

    public static int usingTopDown(int noOfSteps,int[] memos) {
        if(noOfSteps <= 2)
            return  noOfSteps;
        if(memos[noOfSteps] > 0) {
            return memos[noOfSteps];
        }
        memos[noOfSteps] = usingTopDown(noOfSteps - 1, memos) +
                usingTopDown(noOfSteps - 2, memos);
        return memos[noOfSteps];
    }

    // timecomplexity - O(n)
    // spacecomplexity - O(n)
    public static int usingBottomUp(int noOfSteps) {
        if(noOfSteps == 1)
            return  noOfSteps;
       int[] dp  = new int[noOfSteps+1];
       dp[1] = 1;
       dp[2] = 2;
       for(int i = 3;i <=noOfSteps; i++) {
           dp[i] = dp[i-1] + dp[i-2];
       }
       return dp[noOfSteps];
    }

    // timecomplexity - O(n)
    // spacecomplexity - O(1)
    public static int usingBottomUpOptimized(int noOfSteps) {
        if(noOfSteps <= 2)
            return  noOfSteps;
        int oneStepBefore = 2;
        int twoStepBefore = 1;
        for(int i = 3;i <=noOfSteps; i++) {
            int current = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = current;
        }
        return oneStepBefore;
    }


}
