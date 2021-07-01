package com.code.interviews.sc;

public class CustomBlockingQueueMain {
	public static void main(String[] args) {
		CustomBlockingQueue customBlockingQueue = new CustomBlockingQueue();
		// Creating producer and consumer threads
		Thread producer = new Thread(new ProducerAdvanced(customBlockingQueue));
		Thread consumer = new Thread(new ConsumerAdvanced(customBlockingQueue));

		producer.start();
		consumer.start();
	}
}

class ProducerAdvanced implements Runnable {

	private CustomBlockingQueue customBlockingQueue;

	public ProducerAdvanced(CustomBlockingQueue customBlockingQueue) {
		this.customBlockingQueue = customBlockingQueue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				customBlockingQueue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class ConsumerAdvanced implements Runnable {
	private CustomBlockingQueue customBlockingQueue;

	public ConsumerAdvanced(CustomBlockingQueue customBlockingQueue) {
		this.customBlockingQueue = customBlockingQueue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				customBlockingQueue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
