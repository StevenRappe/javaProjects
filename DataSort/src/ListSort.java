/*
 * Steven Rappe
 * Assignment 5
 * List Sort
 * 
 * Creates a list of random UUID's and
 * runs selection sort and merge sort on
 * the list. Checks if lists are sorted
 * with isSorted method.
 */

import java.util.ArrayList;
import java.util.UUID;


public class ListSort {
	
	private static ArrayList<String> list;
	private static ArrayList<String> helpList;

	// main method
	public static void main(String[] args) {
		
		ListSort ls = new ListSort();
		ArrayList<String> selectionSort = new ArrayList<String>();
		int length = list.size();
		
		// run selection sort
		System.out.println("Run selection sort");
		selectionSort = ls.getSelectionSortedCopy(list);
		if (ls.isSorted(selectionSort) == true) {
			System.out.println("Selection sort successful");
		}
		
		// run merge sort
		System.out.println("Run merge sort");
		ls.getMergeSortedCopy(0, length-1);
		if (ls.isSorted(list) == true) {
			System.out.println("Merge sort successful");
		}
	}

	// initialize object 
	public ListSort() {
		list = createRandomList();
		helpList = new ArrayList<String>();
		for (int i=0; i<list.size(); i++) {
			helpList.add(list.get(i));
		}
	}
	
	// create list of random strings
	public ArrayList<String> createRandomList() {
		
		ArrayList<String> randList = new ArrayList<String>();
		UUID randNum;
		String randString;
		
		for (int i=0; i<20000; i++) {
			randNum = UUID.randomUUID();
			randString = randNum.toString();
			randList.add(randString);
		}
		
		return randList;
	}

	// selection sort
	public ArrayList<String> getSelectionSortedCopy(ArrayList<String> unsortedList) {
		int arrLength = unsortedList.size();
		
		String str = "z";
		for (int i=0; i<100; i++) {
			str += "z";
		}
		String curMax = "a", prevUsed = str;
		int indexCompare, upperBound;
		
		ArrayList<String> sortedList = new ArrayList<String>();
		
		for (int i=0; i<arrLength; i++) {
			
			for (int j=0; j<arrLength; j++) {
				
				// if current index is greater than current max.
				indexCompare = unsortedList.get(i).compareTo(curMax);
				// if current index is less than previous sorted value.
				upperBound = unsortedList.get(i).compareTo(prevUsed);
				
				if (indexCompare>0 && upperBound<0){
					curMax = unsortedList.get(i);
				}
			}
			
			sortedList.add(curMax);
			prevUsed = curMax;
		}
		return sortedList;
	}
	
	// merge sort
	public void getMergeSortedCopy(int low, int high) {
		
		if (low < high) {
			// split array
			int middle = low + (high-low)/2;
			
			// recurse
			getMergeSortedCopy(low, middle);
			getMergeSortedCopy(middle + 1, high);
			
			// merge.
			merge(low, middle, high);
		}
	}
	
	// merge two sublists
	public static void merge (int low, int middle, int high) {
		// create helper arrayList
		for (int i=low; i<=high; i++) {
			helpList.set(i, list.get(i));
		}
		
		int i = low, j = middle+1, k = low;
		
		while (i<=middle && j<=high) {
			if (helpList.get(i).compareTo(helpList.get(j)) <= 0) {
				list.set(k, helpList.get(i));
				i++;
			}
			else {
				list.set(k, helpList.get(j));
				j++;
			}
			k++;
		}
		while (i<=middle) {
			list.set(k, helpList.get(i));
			k++;
			i++;
		}
	}
	
	// check if array is sorted
	public boolean isSorted(ArrayList<String> array) {
		for (int i=1; i<array.size(); i++) {
			if (array.get(i).compareTo(array.get(i-1)) < 0) {
				return false;
			}
		}
		return true;
	}
}
