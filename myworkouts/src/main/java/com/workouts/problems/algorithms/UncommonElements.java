package com.workouts.problems.algorithms;

import java.util.HashSet;
import java.util.Set;

public class UncommonElements {

	public static void main(String[] arg) {
		Set<Integer> a1 = new HashSet<>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		a1.add(4);
		Set<Integer> a2 = new HashSet<>();
		a2.add(4);
		a2.add(1);
		a2.add(6);
		a2.add(7);
		System.out.println(find(a1,a2));
	}
	
	public static Set<Integer> find(Set<Integer> a1,Set<Integer> a2) {
		Set<Integer> result = new HashSet<>(a1);
	    for (Integer element : a2) {
	        if (!result.add(element)) {
	            result.remove(element);
	        }
	    }
	    return result;
	}
}
