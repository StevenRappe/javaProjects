
// creates sphere object
public class Sphere implements AreaMeasurable {
	private double radius, surfArea = 0;
	
	public Sphere (double r) {
		radius = r;
	}
	
	public double getArea() {
		surfArea = (radius*radius*radius) * 3.14 * (4/3); // fix algorithm
		return surfArea;
		
	}
	
}