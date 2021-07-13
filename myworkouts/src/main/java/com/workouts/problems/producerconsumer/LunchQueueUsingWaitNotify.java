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

	public static void main(String args[]) {
		hotelSeats = new String[20];
		guysWaitingForLunch = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
				"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "aa", "bb", "cc", "dd", "cc", "dd", "ee", "ff",
				"gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww",
				"xx", "yy", "zz" };
		currentSize = 0;

		SeatAllocater seatAllocater = new SeatAllocater();
		SeatVocater seatVocater = new SeatVocater();

		Runnable allocateSeat = new Runnable() {
			@Override
			public void run() {
				for (int x = 0; x < guysWaitingForLunch.length; x++) {
					seatAllocater.saysHiSirPleaseComeInAndHaveYourLunch(guysWaitingForLunch[x]);
				}
				System.out.println("All guys got seated. Seats are full...");
			}
		};

		Runnable vocateSeat = new Runnable() {
			@Override
			public void run() {
				for (int x = 0; x < guysWaitingForLunch.length; x++) {
					seatVocater.saysHelloSirPleaseVocateAsYouAreDoneWithLunch();
				}
				System.out.println("All guys finished eating. Hotel closed...");
			}
		};

		Thread waiter = new Thread(allocateSeat, "waiter");
		Thread supervisor = new Thread(vocateSeat, "supervisor");

		waiter.start();
		supervisor.start();

		try {
			waiter.join();
			supervisor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static class SeatAllocater {
		public void saysHiSirPleaseComeInAndHaveYourLunch(String eater) {
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

	static class SeatVocater {
		public void saysHelloSirPleaseVocateAsYouAreDoneWithLunch() {
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
