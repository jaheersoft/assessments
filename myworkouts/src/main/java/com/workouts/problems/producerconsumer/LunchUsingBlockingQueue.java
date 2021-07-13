package com.workouts.problems.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * Producer consumer problem.
 * Using blockingqueue implementation - which made simple using just 2 methods.
 */

public class LunchUsingBlockingQueue {
	
	private static BlockingQueue<String> hotelSeats;
	private static String[] guysWaitingForLunch;
	
	public static void main(String args[]) {
		hotelSeats = new ArrayBlockingQueue<>(10);
		guysWaitingForLunch = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","aa"};
		Waiter waiter = new Waiter();
		Supervisor supervisor = new Supervisor();
		Runnable allocateSeat = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < guysWaitingForLunch.length; x++) {
                	waiter.saysHiSirPleaseComeInAndHaveYourLunch(guysWaitingForLunch[x]);
                }
                System.out.println("All guys got seated. Seats are full...");
            }
        };
        Runnable vocateSeat = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < guysWaitingForLunch.length; x++) {
                	supervisor.saysHelloSirPleaseVocateAsYouAreDoneWithLunch();
                }
                System.out.println("All guys finished eating. Hotel closed...");
            }
        };
		Thread seatAllocator = new Thread(allocateSeat,"seatAllocator");
		Thread seatVocater = new Thread(vocateSeat,"seatVocater");
		seatAllocator.start();
		seatVocater.start();
		try {
			seatAllocator.join();
			seatVocater.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static class Waiter {
		public void saysHiSirPleaseComeInAndHaveYourLunch(String eater) {
			try {
				System.out.println("Guy "+eater+" is got seated.");
				hotelSeats.put(eater);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Supervisor {
		public void saysHelloSirPleaseVocateAsYouAreDoneWithLunch() {
			try {
				String vocater = hotelSeats.take();
				System.out.println("Guy "+vocater+" vocated the seated.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
