/*
 * Steven Rappe
 * Assignment 6
 * Ordered Hash
 * 
 * Creates a hashmap of node objects out of indices
 * of a string. Then stores these characters in a
 * priority queue based on their frequency
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;


public class Map {
	
	private static HashMap<String, Integer> hm;
	private static PriorityQueue<Node> pq;

	// creates input string and runs hashmap
	public static void main(String[] args) {
		String input;
		
		// record input string
		Scanner stdin = new Scanner(System.in);
		System.out.println("Please enter a string");
		input = stdin.nextLine();
		
		// create hashmap
		hm = new HashMap<String, Integer>();
		String[] temp = input.split("");
		
		loadMap(temp);
		
		// create priority queue
		PriorityQueueComparator pqc = new PriorityQueueComparator();
		pq = new PriorityQueue<Node>(20, pqc);
		
		addToQueue();
		displayQueue();
	}
	
	// put string keys into hashmap
	static void loadMap(String[] helper) {
		
		for (int i=1; i<helper.length; i++) {
			// if already contains key
			if (hm.containsKey(helper[i])) {
				// update key (key +=1)
				hm.put(helper[i], hm.get(helper[i]) + 1); // this line could have problem
			}
			// else add key
			else {
				hm.put(helper[i], 1);
			}
		}
	}
	
	// add map objects to queue
	static void addToQueue() {
		
		for (String key : hm.keySet()) {
			Node tempNode = new Node(key, hm.get(key));
			pq.add(tempNode);
		}
	}
	
	// poll elements from queue and print them
	static void displayQueue() {
		
		for (int i=0; i<hm.size(); i++) {
			Node n = pq.poll();
			System.out.println("Key: " + n.getKey() + "  Num-Occurances: " + n.getValue());
		}
	}

	// comparator used to order strings in priority queue
	static class PriorityQueueComparator implements Comparator<Node> {
		
		private int val1=0, val2=0;
		
		public int compare(Node n1, Node n2) {
			val1 = n1.getValue();
			val2 = n2.getValue();
			
			return val2 - val1;
		}
	}
}
