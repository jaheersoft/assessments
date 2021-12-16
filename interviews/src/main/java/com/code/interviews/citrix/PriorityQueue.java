package com.code.interviews.citrix;

public interface PriorityQueue {
	/**
	 * Inserts a queue item into the priority queue.
	 */
	public void queue(QueueItem q);

	/**
	 * Returns the item with the highest priority and removes it from the queue.
	 * When there are multiple items with the highest priority, any one of the items
	 * can be returned/removed.
	 */
	public QueueItem dequeue();
}
