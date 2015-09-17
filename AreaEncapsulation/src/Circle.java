
// creates circle object
public class Circle implements AreaMeasurable {
	private double radius, area = 0;
	
	public Circle(double r) {
		radius = r;
	}
	
	public double getArea() {
		area = 2 * radius * 3.14;
		
		return area;
	}
}
