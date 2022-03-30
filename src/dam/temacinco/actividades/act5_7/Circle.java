package dam.temacinco.actividades.act5_7;
/**
 * Clase derivada de Shape (clase abstracta).
 * @author llemi
 *
 */
public class Circle extends Shape {
	protected double radius;
	
	public Circle() {}
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public double getArea() {
		return this.radius*this.radius*Math.PI;
	}
	@Override
	public double getPerimeter() {
		return 2*Math.PI*this.radius;
	}
	@Override
	public String toString() {
		return "Circle [" + super.toString() + ", radius=" + radius + "]";
	}
}