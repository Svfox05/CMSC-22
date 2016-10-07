
public class Circle extends Shape{
	private double radius = 1.0;
	
	public Circle (){
		this.radius = 1.0;
	}
	
	public Circle (double radius) {
		this.radius = 1.0;
	}
	
	public Circle (double radius, String color, boolean filled){
		this.radius = 1.0;
		this.Shape.color = "green";
		this.Shape.filled = true;
	}
	
	public double getRadius (double radius) {
		return radius;
	}
	
	public void setRadius (double radius) {
		if (radius < 0) {
			throw new IllegalArgumentException("Invalid Radius!");
		} 
		this.radius = radius;
	}
	
	public double getArea (double radius) {
		return radius * radius * 3.14;
	}
	
	public double getPerimeter (double radius) {
		return radius * 2 * 3.14;
	}

	public String toString (double radius, String Shape.toString) {
		return String.format("A Circle with radius = %02d, which is a subclass of %s",radius, Shape.toString);
	}
}

	