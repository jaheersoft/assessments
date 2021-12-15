package com.code.interviews.citrix;

public class QuickNextQueue implements PriorityQueue {

	private QueueItem[] queueItemArray;
	private int numberOfItems;
	
	@Override
	public void queue(QueueItem q) {
		queueItemArray[numberOfItems++] = q;
	}

	@Override
	public QueueItem dequeue() {
		return queueItemArray[--numberOfItems];
	}
}
