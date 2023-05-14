package com.workouts.problems.algorithms;

import java.util.HashMap;
import java.util.Map;

public class StringDuplicateCount {

	public static void main(String arg[]) {
		System.out.println(countDuplicates("aaabbccddd"));
	}
	
	public static Map<Character,Integer> countDuplicates(String input) {
		Map<Character,Integer> counts = new HashMap<>();
		for(int i=0;i<input.length();i++) {
			int count = 1;
			if(counts.containsKey(input.charAt(i))) {
				count = counts.get(input.charAt(i));
				count++;
			}
			counts.put(input.charAt(i), count);
		}
		System.out.println(counts.entrySet().stream()
			.map(entry -> entry.getKey().toString().concat(entry.getValue().toString()))
			.reduce((k,v) -> k.concat(v))
			.get());
		return counts;
	}
}
