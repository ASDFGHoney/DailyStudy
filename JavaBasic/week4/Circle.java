package week4;

public class Circle {
	private String name;
	private double x, y;
	private int radius;

	public Circle(String name, double x, double y, int radius) {
		this.radius = radius;
		this.x=x;
		this.y =y;
		this.name = name;
	}
	public void show() {
		System.out.println(this.name + "의 위치는 (" + this.x + "," + this.y + "), 반지름은 " + this.radius);
	}

	public void changePosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

