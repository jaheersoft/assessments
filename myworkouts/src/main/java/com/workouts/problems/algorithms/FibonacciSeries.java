package com.workouts.problems.algorithms;

public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println(usingRecursion(5));
    }

    public static int usingRecursion(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return usingRecursion(n-1) + usingRecursion(n-2);
    }

    //Iterative approach
    public static int usingDPBottomUp(int n) {
        int[] fib = new int[n];
        if(n == 0 || n == 1)
            return 1;
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2;i<n;i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n-1];
    }

    public static int usingDPTopDown(int n) {
        int[] fib = new int[n];
        if(n==1) return 1;
        if(n==2) return 1;
        if(fib[n] !=0 )
            return fib[n];
        fib[n] = usingDPTopDown(n-1) + usingDPTopDown(n-2);
        return fib[n];
    }

    public static int usingBetterIteration(int n) {
        int a=0, b=1, sum = 0, i;
        for(i=0; i<n; i++) {
            sum = a+b; // sum = 1
            a = b; // a = 1
            b = sum; // b=1
        }
        return sum;
    }
}
