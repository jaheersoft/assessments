package com.workouts.problems.algorithms;

import java.util.*;

public class Knapsack {

	public static void main(String[] args) {
		Item guitar = new Item(1,1500);
        Item stereo = new Item(4,3000);
        Item laptop = new Item(3,2000);
        //Item iphone = new Item(1,2000);
        Item na = new Item(0,0);
        List<Item> items = new LinkedList<>();
        items.add(na);
        items.add(guitar);
        items.add(stereo);
        items.add(laptop);
        //items.add(iphone);
        System.out.println(dynamicProgramming(items,4));
	}

	public static int dynamicProgramming(List<Item> items, int knapSackWeight) {
        int[][] knapSackMatrix = new int[items.size()][knapSackWeight+1];
        for(int i=1;i<items.size();i++) {
            for(int j=1;j<=knapSackWeight;j++) {
                if(items.get(i).getWeight() <= j) {
                    int remainingWeight = j - items.get(i).getWeight();
                    int currPrice = items.get(i).getPrice() + knapSackMatrix[i-1][remainingWeight];
                    knapSackMatrix[i][j] = Math.max(currPrice,knapSackMatrix[i-1][j]);
                }
                else {
                    knapSackMatrix[i][j] = knapSackMatrix[i-1][j];
                }
            }
        }
        return knapSackMatrix[items.size()-1][knapSackWeight];
    }

    static class Item {
        private int weight;
        private int price;

        public Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
