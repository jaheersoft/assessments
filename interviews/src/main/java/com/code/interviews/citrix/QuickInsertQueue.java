package com.code.interviews.citrix;

public class QuickInsertQueue implements PriorityQueue {

	private QueueItem[] queueItemArray;
	private int numberOfItems;

	@Override
	public void queue(QueueItem q) {
		queueItemArray[numberOfItems++] = q;
	}

	@Override
	public QueueItem dequeue() {
		int maxIndex = 0;
		for (int i = 1; i < numberOfItems; i++) {
			if (queueItemArray[maxIndex].priority() < queueItemArray[i].priority()) {
				maxIndex = i;
			}
		}
		QueueItem queueItem = queueItemArray[numberOfItems - 1];
		queueItemArray[numberOfItems - 1] = queueItemArray[maxIndex];
		queueItemArray[maxIndex] = queueItem;
		return queueItemArray[--numberOfItems];
	}
}
