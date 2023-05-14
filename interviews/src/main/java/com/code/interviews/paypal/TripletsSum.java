package com.code.interviews.paypal;

import java.util.HashSet;
import java.util.Set;

public class TripletsSum {
	
	public static void main(String arg[]) {
		 int A[] = { 1, 4, 45, 6, 10, 8,2 };
	     int n = 13;
	     findTriplets(A, n);
	}
	
	public static void findTriplets(int arr[],int sum) {
		//Set<Integer> s = new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			Set<Integer> s = new HashSet<>();
			int temp = sum - arr[i];
	        for(int j=i+1;j<arr.length;j++) {
	        	if(arr[j] < temp) {
		        	int newTemp = temp - arr[j];
		        	if (s.contains(newTemp)) {
		                System.out.println(
		                    "Triplets for given sum "
		                    + sum + " is (" + arr[i]
		                    + ", " + arr[j] + ", " + newTemp+ ")");
			        }
		        	s.add(arr[j]);
	        	}
	        }
	        s = null;
		}
	}

}
