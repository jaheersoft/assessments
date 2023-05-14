package com.workouts.problems.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {

	public static void main(String[] args) {
		Map<Integer, Integer> products = new HashMap<>();
		products.put(2000, 1);
		products.put(1500, 1);
		products.put(2000, 3);
		products.put(3000, 4);
		Map<Integer, Integer> maxPricePerWeights = new HashMap<>();
		System.out.println(maxStealingPrice(4, products, maxPricePerWeights));
	}

	public static int maxStealingPriceVer1(int knapsackWeight, Map<Integer, Integer> products,
			Map<Integer, Integer> maxPricePerWeights) {
		for (int i = 1; i <= knapsackWeight; i++) {
			int price = products.get(i) != null ? products.get(i) : 0;
			if (price > 0) {
				int j = 1;
				while (j <= knapsackWeight) {
					if (i == j) {
						if (maxPricePerWeights.get(j) != null) {
							if (price > maxPricePerWeights.get(j)) {
								maxPricePerWeights.put(j, price);
							}
						} else {
							maxPricePerWeights.put(j, price);
						}
					}
					if (j > i) {
						if (maxPricePerWeights.get(j) != null) {
							if (price > maxPricePerWeights.get(j)) {
								if (maxPricePerWeights.get(j - i) != null) {
									maxPricePerWeights.put(j, price + maxPricePerWeights.get(j - i));
								} else {
									maxPricePerWeights.put(j, price);
								}
							}
						} else {
							if (maxPricePerWeights.get(j) != null) {
								if (price > maxPricePerWeights.get(j)) {
									maxPricePerWeights.put(j, price);
								}
							} else {
								maxPricePerWeights.put(j, price);
							}
						}
					}
					j++;
				}
			}
		}
		return maxPricePerWeights.get(4);
	}
	
	public static int maxStealingPrice(int knapsackWeight, Map<Integer, Integer> products,
			Map<Integer, Integer> maxPricePerWeights) {
		for (int i = 1; i <= knapsackWeight; i++) {
			int price = products.get(i) != null ? products.get(i) : 0;
			if (price > 0) {
				int j = 1;
				while (j <= knapsackWeight) {
					if (i == j) {
						if (maxPricePerWeights.get(j) != null) {
							if (price > maxPricePerWeights.get(j)) {
								maxPricePerWeights.put(j, price);
							}
						} else {
							maxPricePerWeights.put(j, price);
						}
					}
					if (j > i) {
						if (maxPricePerWeights.get(j) != null) {
							if (price > maxPricePerWeights.get(j)) {
								if (maxPricePerWeights.get(j - i) != null) {
									maxPricePerWeights.put(j, price + maxPricePerWeights.get(j - i));
								} else {
									maxPricePerWeights.put(j, price);
								}
							}
						} else {
							if (maxPricePerWeights.get(j) != null) {
								if (price > maxPricePerWeights.get(j)) {
									maxPricePerWeights.put(j, price);
								}
							} else {
								maxPricePerWeights.put(j, price);
							}
						}
					}
					j++;
				}
			}
		}
		return maxPricePerWeights.get(4);
	}
}
