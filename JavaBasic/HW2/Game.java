package HW2;

import java.util.Scanner;

class Police extends GameObject {

	public Police(int x, int y) {
		super(x, y);
	}

	@Override
	protected boolean move() {
		int rnd = (int) (Math.random() * 5 + 1);
		switch (rnd) {
			case 1:
				if (this.x > 0) this.x -= 1;
				break;
			case 2:
				if (this.getY() < 2) this.y += 1;
				break;
			case 3:
				if (this.getX() < 2) this.x += 1;
				break;
			case 4:
				if (this.getY() > 0) this.y -= 1;
				break;
			case 5:
				break;
		}

		return false;
	}

	@Override
	protected char getShape() {
		return 'P';
	}
}

class Thief extends GameObject {

	public Thief(int x, int y) {
		super(x, y);
	}

	@Override
	protected boolean move() {
		System.out.print("왼쪽(a), 아래(s), 위(w), 오른쪽(d), 도둑질(r) >> ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();

		switch (input) {
			case "a":
				if (this.x > 0) this.x -= 1;
				break;
			case "s":
				if (this.getY() < 2) this.y += 1;
				break;
			case "d":
				if (this.getX() < 2) this.x += 1;
				break;
			case "w":
				if (this.getY() > 0) this.y -= 1;
				break;
			case "r":
				return true;
		}
		return false;
	}

	@Override
	protected char getShape() {
		return '&';
	}
}

public class Game {
	static Police po = new Police(0, 0);
	static Thief th = new Thief(2, 2);

	static void print(char[][] arr) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (th.getX() == j && th.getY() == i) System.out.print(th.getShape());
				else if (po.getX() == j && po.getY() == i) System.out.print(po.getShape());
				else System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("송치헌/컴퓨터공학과/12171637\n");
		char[][] arr = {{'^', '^', '^'}, {'^', '^', '^'}, {'^', '^', '^'}};
		int count = 0;
		while (true) {
			print(arr);
			if (th.move() && arr[th.getY()][th.getX()] != '-') {
				arr[th.getY()][th.getX()] = '-';
				count += 1;
			}
			po.move();
			if(th.collide(po)){
				System.out.println("당신이 졌습니다!");
				break;
			}
			if(count == 9){
				System.out.println("당신이 이겼습니다!");
				break;
			}
		}
	}
}
