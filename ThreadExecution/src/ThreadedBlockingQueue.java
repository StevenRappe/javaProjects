/*
 * Steven Rappe
 * Assignment 7
 * Threaded Blocking Queue
 * 
 * Creates a linked blocking queue which stores UUIDs
 * that are produced by the producer. The consumer then
 * takes them off the queue and records the maximum
 * string compared lexicographically.
 */

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class ThreadedBlockingQueue {
	static LinkedBlockingQueue<UUID> queue;
	
	public ThreadedBlockingQueue(LinkedBlockingQueue<UUID> q) {
		this.queue = q;
	}
	
	// creates queue, producer, and consumer and executes them
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		LinkedBlockingQueue<UUID> lbq = new LinkedBlockingQueue<UUID>(100000);
		new ThreadedBlockingQueue(lbq);
		
		Runnable prod = new Producer();
		Runnable cons = new Consumer();;
		executor.execute(prod);
		executor.execute(cons);
		
		executor.shutdown();
	}
}
