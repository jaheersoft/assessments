package com.workouts.problems.algorithms;


import java.util.*;

public class PairSumUnSorted {

    public static void main(String[] arg) {
        int[] input = {-1,3,4,2};
        //System.out.println(Arrays.toString(hashMap(input, 3)));
        System.out.println(Arrays.toString(hashSet(input, 3)));
    }

    //Time complexity - O(n)
    //Space complexity - O(n)
    public static int[] hashMap(int[] input,int target) {
        Map<Integer,Integer> pairsForSum = new HashMap<>();
        for(int i=0;i < input.length; i++) {
            int complement = target - input[i];
            if(pairsForSum.containsKey(complement)) {
                return new int[]{pairsForSum.get(complement),i};
            }
            pairsForSum.put(input[i],i);
        }
        return new int[]{};
    }

    public static int[] hashSet(int arr[],int sum) {
        Set<Integer> s = new HashSet<>();
        for (int j : arr) {
            int temp = sum - j;
            if (s.contains(temp)) {
                System.out.println(
                        "Pair with given sum "
                                + sum + " is (" + j
                                + ", " + temp + ")");
                return new int[]{j, temp};
            }
            s.add(j);
        }
        return new int[]{};
    }
}
