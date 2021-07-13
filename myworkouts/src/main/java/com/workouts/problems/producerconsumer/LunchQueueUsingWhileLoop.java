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
		guysWaitingForLunch = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
											"aa","bb","cc","dd","cc","dd","ee","ff","gg","hh","ii","jj","kk","ll","mm","nn","oo","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"};
		currentSize = 0;
		
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
		
		//without join -> seat allocater and seat vocater acts as if they fighted and they are not talking to each other
		//with join -> seat allocater and seat vocater acts as they are friends and they coordinate in their works like hey i do this, once i am done pls do your work - we can work together to solve a problem.
		seatAllocator.join();
		seatVocater.join();
	}
	
	static class Waiter {
		public void saysHiSirPleaseComeInAndHaveYourLunch(String eater) {
			while(currentSize == hotelSeats.length) {
				System.out.println("Waiting for seat to be available.");
				try {
					Thread.sleep(2000); // this was at first set as 1 sec which is causing an index out of bound issue.
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
	
	static class Supervisor {
		public void saysHelloSirPleaseVocateAsYouAreDoneWithLunch() {
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
