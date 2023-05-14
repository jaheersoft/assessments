package com.workouts.problems.algorithms;

public class BinarySearch {

	public static void main(String arg[]) {
		int arr[] = { 2, 3, 4, 10, 40 };
		System.out.println(search(arr, 10));
	}

	public static int search(int arr[], int searchItem) {
		int leftIndex = 0, rightIndex = arr.length - 1;
		while (leftIndex <= rightIndex) {
			int medianIndex = leftIndex + (rightIndex - 1) / 2;
			if (arr[medianIndex] == searchItem) {
				return medianIndex;
			}
			if (arr[medianIndex] < searchItem) {
				leftIndex = medianIndex + 1;
			} else {
				rightIndex = medianIndex - 1;
			}
		}
		return -1;
	}
}
