/*
 * Steven Rappe
 * Assignment 3
 * Geometric Measurement
 * 
 * Creates 100 shapes (rectangle, circle, box, sphere) with dimensions
 * between 0-1, randomly chosen between the 4 possibilities. Then sums
 * the surface area of all of the created shapes together.
 */

import java.util.ArrayList;
import java.util.Random;


public class Main {

	// creates shapes and sums their area and shape totals
	public static void main (String [] args) {
		int randNum;
		int recCount=0, circCount=0, boxCount=0, sphrCount=0;
		double areaSum=0, randDoub1, randDoub2, randDoub3;
		Random rand = new Random();
		
		ArrayList <AreaMeasurable> list = new ArrayList <AreaMeasurable>(100);
		
		// populate array with random
		for (int i=0; i<100; i++) {
			randDoub1 = 0;
			randDoub2 = 0;
			randDoub3 = 0;
			randNum = (int) (Math.random() * 4);
			
			// add rectangle
			if (randNum < 1) {
				randDoub1 = rand.nextDouble();
				randDoub2 = rand.nextDouble();
				
				list.add(new Rectangle(randDoub1, randDoub2));
				recCount += 1;
			}
			
			// add circle
			else if (randNum >= 1 && randNum < 2) {
				randDoub1 = rand.nextDouble();
				
				list.add(new Circle(randDoub1));
				circCount += 1;
			}
			
			// add box
			else if (randNum >= 2 && randNum < 3) {
				randDoub1 = rand.nextDouble();
				randDoub2 = rand.nextDouble();
				randDoub3 = rand.nextDouble();
				
				list.add(new Box(randDoub1, randDoub2, randDoub3));
				boxCount += 1;
			}
			
			// add sphere
			else if (randNum >= 3 && randNum < 4) {
				randDoub1 = rand.nextDouble();
				
				list.add(new Sphere(randDoub1));
				sphrCount += 1;
			}
		}
		
		// print shape counts
		System.out.println("Rectangles: " + recCount);
		System.out.println("circles: " + circCount);
		System.out.println("Boxes: " + boxCount);
		System.out.println("Spheres: " + sphrCount);
		
		// sum and display total area
		for (AreaMeasurable e : list) {
			
			areaSum += e.getArea();
			
		}
		System.out.println("Area sum: " + areaSum);
	}
}
