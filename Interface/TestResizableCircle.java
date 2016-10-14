
public class TestResizableCircle {

	public static void main(String[] args) {

		Resizable c1 = new ResizableCircle(2.0);

		c1.resize(50);
		Circle c = (Circle) c1;
		System.out.println(c.radius);
	}
}