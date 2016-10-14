
public class ResizableCircle extends Circle implements Resizable {


	public ResizableCircle(double radius) {
		super(radius);
	}
	
	public void resize(int percent) { //50   //r = 100 + 50 = 150

		radius += radius * (percent / 100.0);

	}
}