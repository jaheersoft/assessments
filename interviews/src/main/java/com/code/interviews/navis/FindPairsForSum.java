package com.code.interviews.navis;

import java.util.HashSet;
import java.util.Set;

public class FindPairsForSum {
	
	public static void main(String args[]) {
		 int A[] = { 1, 4, 45, 6, 10, 8 };
	     int n = 5;
	     printpairs(A, n);
	}

	static void printpairs(int arr[],int sum) {
		Set<Integer> s = new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			int temp = sum - arr[i];
			if (s.contains(temp)) {
                System.out.println(
                    "Pair with given sum "
                    + sum + " is (" + arr[i]
                    + ", " + temp + ")");
	        }
	        s.add(arr[i]);
		}
	}
}
