package com.code.interviews.sc;

import java.util.LinkedList;
import java.util.List;
/*
 There are N dishes in a row with the ith dish being of type Di. 
 Some dishes may be of the same type as one another.
You're very hungry, but you'd also like to keep things interesting. 
The N dishes will arrive in front of you, one after another in order, 
and for each one you'll eat it as long as it isn't the same type as any 
of the previous K dishes you've eaten. You eat very fast, 
so you can consume a dish before the next one gets to you. 
Any dishes you choose not to eat as they pass will be eaten by others. 
Determine how many dishes you'll end up eating.

1≤N≤500,000
1≤K≤N
1≤Di≤1,000,000

N = 6
D = [1, 2, 3, 3, 2, 1]
K = 1
Expected Return Value = 5

N = 7
D = [1, 2, 1, 2, 1, 2, 1]
K = 2
Expected Return Value = 2
*/
public class FreshFoodEater {

	public static void main(String arg[]) {
		int[] foods = {1, 2, 1, 2, 1, 2, 1, 1};
		System.out.println("Count =="+countFoodsEaten(foods,2));
	}
	
	public static int countFoodsEaten(int[] foods,int freshFoodFlag) {
		List<Integer> foodsEaten = new LinkedList<>();
		for(int i = 0;i<foods.length;i++) {
			if(i < freshFoodFlag) {
				foodsEaten.add(foods[i]);
			} else {
				boolean isPresent = false;
				for(int j = foodsEaten.size()-1;j > foodsEaten.size()-(freshFoodFlag+1);j--) {
					if(foodsEaten.get(j) == foods[i]) {
						isPresent = true;
					}
				}
				if(!isPresent) {
					foodsEaten.add(foods[i]);
				}
			}
		}
		foodsEaten.forEach(System.out::println);
		return foodsEaten.size();
	}
}
