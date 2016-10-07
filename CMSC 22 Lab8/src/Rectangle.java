/**
 * 
 */

/**
 * @author User
 *
 */
public class Rectangle extends Shape {
	
	private double width = 1.0;
	private double length = 1.0;

	public Rectangle () {
		this.width = 1.0;
		this.length = 1.0;
	}
	
	public Rectangle (double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	public Rectangle (double width, double length, String color, boolean filled) {
		this.width = 1.0;
		this.length = 1.0;
		this.Shape.color = "green";
		this.Shape.filled = true;
	}
	
	public double getWidth (double width) {
		return width;
	}
	
	public void setWidth (double width) {
		if(width < 0) {
			throw new IllegalArgumentException("Invalid Width!");
		} 
		this.width = width;
	}
	
	public double getLength (double length) {
		return length;
	}
	
	public void setLength (double length) {
		if(length < 0) {
			throw new IllegalArgumentException("Invalid Width!");
		} 
		this.length = length;
	}
	
	public double getArea (double width, double length) {
		return width * length;
	}
	
	public double getPerimeter (double width, double length) {
		return (2 * width) + (2 * length);
	}
	
	public String toString (double width, double length, String Shape.toString) {
		return String.format("A Rectangle with width=%02d and length=%02d, which is a subclass of %s", width, length, Shape.toString);
	}

}

