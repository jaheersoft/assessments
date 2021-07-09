package com.workouts.problems.producerconsumer;


/*
 * Sample workout for producer consumer problem.
 * Lunch queue using while loop with thread.sleep. it take lot of time and performance is bad here.
 * when the input size i.e guysWaitingForLunch array size increases this program can fail. to fix that again we have to update the seconds at line 59 and 76
 */

public class LunchQueueUsingWhileLoop {
	
	private static String[] hotelSeats;
	private static String[] guysWaitingForLunch;
	private static int currentSize;

	public static void main(String args[]) throws InterruptedException {
		hotelSeats = new String[10];
		guysWaitingForLunch = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","aa"};
		currentSize = 0;
		
		HiComeIn hiComeIn = new HiComeIn();
		HiStandUp hiStandUp = new HiStandUp();
		
		Runnable sitInTheChairAndEatLunch = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < guysWaitingForLunch.length; x++) {
                	hiComeIn.andEat(guysWaitingForLunch[x]);
                }
                System.out.println("All guys got seated. Seats are full...");
            }
        };
        
        Runnable vacoteTheChairAfterEatingLunch = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < guysWaitingForLunch.length; x++) {
                	hiStandUp.andVocate();
                }
                System.out.println("All guys finished eating. Hotel closed...");
            }
        };
		
		Thread sitAndEatLunch = new Thread(sitInTheChairAndEatLunch,"sitAndEatLunch");
		Thread vocateAfterEatingLunch = new Thread(vacoteTheChairAfterEatingLunch,"vocateAfterEatingLunch");
		
		sitAndEatLunch.start();
		vocateAfterEatingLunch.start();
		
		sitAndEatLunch.join();
		vocateAfterEatingLunch.join();
	}
	
	static class HiComeIn {
		public void andEat(String eater) {
			while(currentSize == hotelSeats.length) {
				System.out.println("Waiting for seat to be available.");
				try {
					Thread.sleep(2000); // this was at first 1 sec which is causing an index out of bound issue.
									    // to reproduce the issue set it to 1000.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Guy "+eater+" is seated at "+currentSize+".");
			hotelSeats[currentSize] = eater; //eater sat at this seat now
			currentSize++;
		}
	}
	
	static class HiStandUp {
		public void andVocate() {
			while(currentSize == 0) {
				System.out.println("All seats are available now.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			--currentSize;
			System.out.println("Guy "+hotelSeats[currentSize]+" at seat "+currentSize+" vocated.");
			hotelSeats[currentSize] = ""; // eater vocated the seat now
		}
	}
	
}
