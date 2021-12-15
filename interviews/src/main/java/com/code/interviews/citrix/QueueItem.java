package com.code.interviews.citrix;

public interface QueueItem {
	/**
	 * Returns the priority of this item. The priority is guaranteed to be between 0
	 * and 99, where 0 is lowest and 99 is highest priority. There could be multiple
	 * items with the same priority.
	 */
	public int priority();
}
