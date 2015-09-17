/*
 * Steven Rappe
 * Assignment 2
 * Array Compare
 * 
 * Creates a dense array of type double and a sparse arraylist
 * of type double and compares the efficiency of each list's
 * sum function.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ArrayCompare {
	
	// create dense array
	public static double[] createDenseArray(int length, double density) {
		
		double randNum;
		double[] denseArray = new double[length];
		
		for (int i=0; i<length; i++) {
			Random rand = new Random();
			randNum = rand.nextDouble();
			
			if (randNum < density) {
				denseArray[i] = randNum;
			}
			else {
				denseArray[i] = 0.0;
			}
		}
		return denseArray;
	}
	
	// create sparse array
	public static ArrayList<Double> createSparseArray(int length, double density) {
		
		double randNum;
		ArrayList<Double> sparseArray = new ArrayList<Double>(length);
		
		for (int i=0; i<length; i++) {
			Random rand = new Random();
			randNum = rand.nextDouble();
			
			if (randNum < density) {
				sparseArray.add(randNum);
			}
		}
		return sparseArray;
	}
	
	// sum double dense array
	public static double denseSum(double[] array) {
		
		double sum = 0;
		
		for (int i=0; i<array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	// sum double sparse arrayList
	public static double sparseSum(ArrayList<Double> arrayList) {
		
		double sum = 0;
		
		for (int i=0; i<arrayList.size(); i++) {
			sum += arrayList.get(i);
		}
		return sum;
	}

	// run methods, display results
	public static void main(String args[]) {
		
		int length = 0;
		double density = 0.0, denseSum, sparseSum;
		double[] denseArray;
		ArrayList<Double> sparseArray;
		Scanner scan = new Scanner(System.in);
		int c1 = 0, c2 = 0;
		
		// get array length input
		while (c1 == 0) {
			try {
				System.out.println("Enter integer length: ");
				length = Integer.parseInt(scan.nextLine());
				c1 = 1;
				} catch(Exception e) {
				System.out.println("Invalid input");
			}
		}
		
		// get double density input
		while (c2 == 0) {
			try {
				System.out.println("Enter a density of type double between 0.0 - 1.0: ");
				density = Double.parseDouble(scan.nextLine());
				c2 = 1;
				} catch(Exception e) {
				System.out.println("Invalid input");
			}
			if (density < 0.0 || density > 1.0) {
				System.out.println("Density must be between 0.0 - 1.0");
				c2 = 0;
			}
		}
		
		denseArray = createDenseArray(length, density);
		System.out.println("createDenseArray:  length: " + length + "  time: " + System.nanoTime());
		
		sparseArray = createSparseArray(length, density);
		System.out.println("createSparseArray:  length: " + length + "  time: " + System.nanoTime());
		
		denseSum = denseSum(denseArray);
		System.out.println("dense Sum = " + denseSum + "  time: " + System.nanoTime());
		
		sparseSum = sparseSum(sparseArray);
		System.out.println("Sparse Sum = " + sparseSum + "  time: " + System.nanoTime());
	}
	
}