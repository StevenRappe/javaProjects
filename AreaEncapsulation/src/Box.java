
// creates box object
public class Box implements AreaMeasurable {
	private double length, width, depth, surfArea = 0;
	
	public Box (double l, double w, double d) {
		length = l;
		width = w;
		depth = d;
	}
	
	public double getArea() {
		surfArea = 2*length + 2*width + 2*depth;
		return surfArea;
		
	}
	
}