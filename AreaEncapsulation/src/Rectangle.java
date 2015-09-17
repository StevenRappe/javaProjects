
// creates rectangle object
public class Rectangle implements AreaMeasurable {
	private double length, width, area = 0;
	
	public Rectangle(double l, double w) {
		length = l;
		width = w;
	}
	
	public double getArea() {
		area = length * width;
		return area;
		
	}
	
}
