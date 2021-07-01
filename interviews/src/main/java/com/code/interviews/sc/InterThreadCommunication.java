package com.code.interviews.sc;

import java.util.LinkedList;
import java.util.Queue;

public class InterThreadCommunication {

	public static void main(String args[]) {
        final Queue<Integer> sharedQ = new LinkedList<>();
        Thread producer = new Producer(sharedQ);
        Thread consumer = new Consumer(sharedQ);
        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {
    private final Queue<Integer> sharedQ;

    public Producer(Queue<Integer> sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            synchronized (sharedQ) {
                while (sharedQ.size() >= 1) {
                    try {
                    	System.out.println("Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("producing : " + i);
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}

class Consumer extends Thread {
    private final Queue<Integer> sharedQ;

    public Consumer(Queue<Integer> sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() == 0) {
                    try {
                    	System.out.println("Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                int number = sharedQ.poll();
                System.out.println("consuming : " + number );
                sharedQ.notify();
                //termination condition
                if(number == 3){break; }
            }
        }
    }
}