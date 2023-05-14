package com.code.interviews.toyota;

public class MaximumSubArraySum {
	
	public static void main(String arg[]) {
		// TODO Auto-generated method stub
		int arr[] = {-2,-5,6,-2,-3,1,5,-6};
 		System.out.println(compute(arr));
	}
	
	public static int compute(int arr[]) {
		int maxSoFar = arr[0];
		int currMax  = arr[0];
		for(int i = 1;i<arr.length;i++) {
			System.out.println("arr[i] == "+arr[i]);
			System.out.println("arr[i]+currMax == "+(arr[i]+currMax));
			currMax = Math.max(arr[i], arr[i]+currMax);
			System.out.println("currMax == "+Math.max(arr[i], arr[i]+currMax));
			//System.out.println("Math.max(currMax, maxSoFar) == "+Math.max(currMax, maxSoFar));
			maxSoFar = Math.max(currMax, maxSoFar);
			System.out.println("maxSoFar == "+Math.max(currMax, maxSoFar));
		}
		return maxSoFar;
	}
}
