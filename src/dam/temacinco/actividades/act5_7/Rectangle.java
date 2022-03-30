package dam.temacinco.actividades.act5_7;

public class Rectangle extends Shape {
	protected double width, height;
	
	public Rectangle() {}
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	public Rectangle(double width, double height, String color, boolean filled) {
		super(color, filled);
		// No sé por qué no deja poner this antes de super
		// ni super antes de this. No es posible la escalada de 
		// constructores por alguna razón.
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public double getArea() {
		return this.width*this.height;
	}
	@Override
	public double getPerimeter() {
		return this.height*2+this.width*2;
	}
	
	@Override
	public String toString() {
		return "Rectangle [" + super.toString() + ", width=" + this.width + ", height=" + this.height + "]";
	}
}