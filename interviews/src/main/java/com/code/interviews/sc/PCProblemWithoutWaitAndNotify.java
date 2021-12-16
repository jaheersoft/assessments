package com.code.interviews.sc;

import java.util.ArrayList;
import java.util.List;

public class PCProblemWithoutWaitAndNotify {

	static class Producer implements Runnable {

		boolean productionInProcess;
		List<Integer> list;

		Producer() {
			productionInProcess = true;
			list = new ArrayList<>();
		}

		@Override
		public void run() {
			for (int i = 1; i <= 10; i++) {
				list.add(i);
				System.out.println("Producer is still Producing, Produced : " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			productionInProcess = false;
		}

	}

	static class Consumer implements Runnable {

		Producer prod;

		Consumer(Producer obj) {
			prod = obj;
		}

		@Override
		public void run() {
			while (this.prod.productionInProcess) {
				System.out.println("Consumer waiting for production to get over.");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Production is over, consumer can consume.");
			int productSize = this.prod.list.size();
			for (int i = 0; i < productSize; i++) {
				System.out.println("Consumed : " + this.prod.list.remove(0) + " ");
			}
		}

	}

	public static void main(String args[]) throws InterruptedException {

		Producer prod = new Producer();
		Consumer cons = new Consumer(prod);

		Thread prodThread = new Thread(prod, "prodThread");
		Thread consThread = new Thread(cons, "consThread");

		prodThread.start(); // start producer thread.
		consThread.start(); // start consumer thread.
		
		

	}

}
