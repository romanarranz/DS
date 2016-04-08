package example;

public class CircleData {
	private double radius;
	private Color color;
	private Point origin;
	
	public CircleData(double radius, Color color, Point origin) {
		this.radius = radius;
		this.color = color;
	    this.origin = origin;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public Point getOrigin() {
		return this.origin;
	}
}
