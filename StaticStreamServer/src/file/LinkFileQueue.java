/*
 * Copyright (C) 2017, Cenxui Lin, https://xenxuilin.com. All rights reserved.
 * 
 * 
 * 
 * 
 */

package file;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * @author cenxui
 *
 */

@ThreadSafe
final class LinkFileQueue {
	
	private static final LinkFileQueue instance = new LinkFileQueue();
	
	private final Queue<LinkFile> queue = new ConcurrentLinkedQueue<>();
	
	private LinkFileQueue() {
		
	}
	
	public static LinkFileQueue getInstance() {
		return instance;
	}
	
	public void offer(LinkFile linkFile) {
		if (linkFile == null) {
			throw new RuntimeException("linkFile can not be null");
		}
		queue.offer(linkFile);
	}
	
	LinkFile peek() {
		return queue.peek();
	}
	
	LinkFile poll() {
		return queue.poll();
	}
}
