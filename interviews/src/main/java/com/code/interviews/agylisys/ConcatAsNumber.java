package com.code.interviews.agylisys;

public class ConcatAsNumber {

	public static void main(String arg[]) {
		int arr[] = {4,1,9,8,3,4,5,6,7,3,8,9};
		long start = System.currentTimeMillis();
		long output = concatArrayNormal(arr);
		long end = System.currentTimeMillis();
		System.out.println("Counting takes " +(end - start) + "ms"+" for output "+output);
		
		long start1 = System.currentTimeMillis();
		int output1 = ConcatenateArr(arr);
		long end1 = System.currentTimeMillis();
		System.out.println("Counting takes " +(end1 - start1) + "ms"+" for output "+output1);
		
		long start2 = System.currentTimeMillis();
		String output2 = concatArrayString(arr);
		long end2 = System.currentTimeMillis();
		System.out.println("Counting takes " +(end2 - start2) + "ms"+" for output "+output2);
	}
	
	public static long concatArrayNormal(int arr[]) {
		long output = arr[arr.length-1];
		long j = 1L;
		for(int i = arr.length-2;i > -1;i--) {
			j = j+(j*9);
			System.out.println(j);
			output = output+(arr[i]*j);
			System.out.println(output);
		}
		return output;
	}
	
	public static int ConcatenateArr(int[] arr)
	{
	     
	    // Stores the resulting integer value
	    int ans = arr[0];
	 
	    // Traverse the array arr[]
	    for(int i = 1; i < arr.length-1; i++)
	    {
	         
	        // Stores the count of digits of
	        // arr[i]
	    	System.out.println(Math.log10(arr[i]) + 1);
	    	System.out.println((int)Math.floor(Math.log10(arr[i]) + 1));
	        int l = (int)Math.floor(Math.log10(arr[i]) + 1);
	 
	        // Update ans
	        System.out.println((int)Math.pow(10, l));
	        ans = ans * (int)Math.pow(10, l);
	 
	        // Increment ans by arr[i]
	        System.out.println(ans);
	        ans += arr[i];
	    }
	     
	    // Return the ans
	    return ans;
	}
	
	public static String concatArrayString(int arr[]) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < arr.length-1;i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}
