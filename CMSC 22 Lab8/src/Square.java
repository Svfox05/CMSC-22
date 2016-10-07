
public class Square extends Rectangle {
	
	private double side = 1.0;
	
	public Square () {
		this.side = 1.0;
	}
	
	public Square (double side) {
		public Rectangle (width, length) {
			this.width = side;
			this.length = side;
		}
	}
	
	public double getSide (double side) {
		return side;
	}
	
	public void setSide (double side) {
		if(side < 0) {
			throw new IllegalArgumentException("Invalid Side!");
		} 
		this.side = side;
	}
	
	public void setWidth (double side) {
		if(side < 0) {
			throw new IllegalArgumentException("Invalid Width!");
		} 
		this.side = side;
	}
	
	public void setLength (double side) {
		if(side < 0) {
			throw new IllegalArgumentException("Invalid Length!");
		} 
		this.side = side;
	}
	
	public String toString (double side, String Shape.toString) {
		return String.format("A Square with width=%02d and length=%02d, which is a subclass of %s", side, side, Shape.toString);
	}
}
