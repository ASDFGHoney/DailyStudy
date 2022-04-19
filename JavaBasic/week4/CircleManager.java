package week4;

import java.util.Scanner;

public class CircleManager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Circle[] c = new Circle[3];

		for (int i = 0; i < c.length; i++) {
			System.out.print(i + "번 원의 이름, x좌표, y좌표, 반지름 입력 >> ");
			c[i] = new Circle(scanner.next(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
		}
		for (int i = 0; i < c.length; i++) {
			c[i].show();
		}
		System.out.print("위치를 바꾸고 싶은 원의 번호와 변경할 x, y 좌표를 입력하세요 >> ");
		int index = scanner.nextInt();
		c[index].changePosition(scanner.nextDouble(), scanner.nextDouble());
		c[index].show();

		scanner.close();
	}
}
