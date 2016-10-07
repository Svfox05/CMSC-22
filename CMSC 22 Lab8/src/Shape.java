
public class Shape {
	 
	private String color = "red";
	private boolean filled = true;
	
	public Shape (){
		this.color = "green";
		this.filled = true;
	}	
	
	
	public Shape (String color, boolean filled) {
		color = this.color;
		filled = this.filled;
	}
	
	public String getColor (){
		return color;
	}
	
	public void setColor (String color) {
		if(color == null) {
			throw new IllegalArgumentException("Invalid Color!");
		} 
		this.color = color;
		
	}
	
	public boolean isFilled () {
		return filled;
	}
	
	public void setFilled (boolean filled){
		if(filled == true) {
			this.filled = true;
		} else
			this.filled = false;
	}
	
	public String toString (String color, boolean filled) {
		return String.format("A Shape with the color of %s and is %d.", color, boolean.class);
	}
}
