package com.workouts.problems.producerconsumer;

/*
 *  Sample workout for producer consumer problem.
 *  LunchQueue using wait notify machanism. efficient way of solving the producer consumer problem.
 *  No matter what is the input size is this works fine.
 */
public class LunchQueueUsingWaitNotify {
	private static String[] hotelSeats;
	private static String[] guysWaitingForLunch;
	private static int currentSize;

	static Object key = new Object();

	public static void main(String args[]) throws InterruptedException {
		hotelSeats = new String[20];
		guysWaitingForLunch = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
				"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "aa", "bb", "cc", "dd", "cc", "dd", "ee", "ff",
				"gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww",
				"xx", "yy", "zz" };
		currentSize = 0;

		WaiterSays waiterSays = new WaiterSays();
		OwnerSays ownerSays = new OwnerSays();

		Runnable allocateSeat = new Runnable() {
			@Override
			public void run() {
				for (int x = 0; x < guysWaitingForLunch.length; x++) {
					waiterSays.hiSirPleaseComeInAndHaveYourLunch(guysWaitingForLunch[x]);
				}
				System.out.println("All guys got seated. Seats are full...");
			}
		};

		Runnable vocateSeat = new Runnable() {
			@Override
			public void run() {
				for (int x = 0; x < guysWaitingForLunch.length; x++) {
					ownerSays.helloSirPleaseVocateAsYouAreDoneWithLunch();
				}
				System.out.println("All guys finished eating. Hotel closed...");
			}
		};

		Thread seatAllocator = new Thread(allocateSeat, "seatAllocator");
		Thread seatVocater = new Thread(vocateSeat, "seatVocater");

		seatAllocator.start();
		seatVocater.start();

		seatAllocator.join();
		seatVocater.join();
	}

	static class WaiterSays {
		public void hiSirPleaseComeInAndHaveYourLunch(String eater) {
			synchronized (key) {
				if (currentSize == hotelSeats.length) {
					System.out.println("Waiting for seat to be available.");
					try {
						key.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Guy " + eater + " is seated at " + currentSize + ".");
				hotelSeats[currentSize] = eater; // eater sat at this seat now
				currentSize++;
				key.notifyAll();
			}
		}
	}

	static class OwnerSays {
		public void helloSirPleaseVocateAsYouAreDoneWithLunch() {
			synchronized (key) {
				if (currentSize == 0) {
					System.out.println("All seats are available now.");
					try {
						key.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				--currentSize;
				System.out.println("Guy " + hotelSeats[currentSize] + " at seat " + currentSize + " vocated.");
				hotelSeats[currentSize] = ""; // eater vocated the seat now
				key.notifyAll();
			}
		}
	}
}
