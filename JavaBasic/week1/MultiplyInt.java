package week1;

import java.util.Scanner;

public class MultiplyInt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("곱하고자 하는 두 수 입력 >> ");
		int a;
		int b;
		a = scanner.nextInt();
		b = scanner.nextInt();

		System.out.println(a+"x"+b+"="+(a*b));
		scanner.close();
	}
}
