package dam.temacinco.actividades.act5_7;

public class Square extends Rectangle {
	public Square() {}
	public Square(double side) {
		super(side, side);
	}
	
	public double getSide() {
		// Son iguales, podría haber sido cualquiera.
		return this.height;
	}
	public void setSide(double side) {
		this.height = side;
		this.width = side;
	}
	
	// Confiamos en que quien cambie un valor cambie
	// también el otro, porque estos métodos no se deberían
	// implementar.
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Square [" + super.toString() +", width=" + width + ", height=" + height + "]]";
	}
}
