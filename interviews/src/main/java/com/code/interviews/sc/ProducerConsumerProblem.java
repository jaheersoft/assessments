package com.code.interviews.sc;

public class ProducerConsumerProblem {
	static Object key = new Object();
	private static boolean[] buffer;
    private static int currentSize;

    public static void main(String[] args) throws InterruptedException {
        buffer = new boolean[10];
        currentSize = 0;

        final Producer producer = new Producer();
        final Consumer consumer = new Consumer();

        Runnable prodRunn = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 50; x++) {
                    producer.produce();
                }
                System.out.println("Produced...");
            }
        };

        Runnable consRunn = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 50; x++) {
                    consumer.consume();
                }
                System.out.println("Consumer...");
            }
        };

        Thread prodThread = new Thread(prodRunn);
        Thread consThread = new Thread(consRunn);

        prodThread.start();
        consThread.start();

        prodThread.join();
        consThread.join();

        System.out.println("Buffer size : " + currentSize);
    }

    static class Producer {
        void produce() {
        	synchronized(key) {
        		System.out.println("producer currentSize == "+currentSize);
        		System.out.println("producer buffer.length == "+buffer.length);
        		if(currentSize == buffer.length) {
	        		try {
	        			System.out.println("Producer waiting");
	        			key.wait();
	        		} catch(InterruptedException e) {
	        			e.printStackTrace();
	        		}
        		}
	    		buffer[currentSize] = true;
	    		System.out.println("current size before increment ===== "+currentSize+" buffer of current size value == "+buffer[currentSize]);
	    		currentSize++;
	    		System.out.println("producer notifying all");
	    		key.notifyAll();
        	}
        }
    }

    static class Consumer {
        void consume() {
        	synchronized(key) {
        		System.out.println("consumer currentSize == "+currentSize);
        		System.out.println("consumer buffer.length == "+buffer.length);
        		if(currentSize == 0) {
        			try {
        				System.out.println("Consumer waiting");
        				key.wait();
        			} catch(InterruptedException e) {
	        			e.printStackTrace();
	        		}
        		}
                buffer[--currentSize] = false;
                System.out.println("current size after decrement ===== "+currentSize+" buffer of current size value == "+buffer[currentSize]);
                System.out.println("Consumer notifying all");
                key.notifyAll();
        	}
        }
    }
}

