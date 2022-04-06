package week1;

import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {
		System.out.println("이름, 도시, 나이, 체중, 독신여부를 체트");
		Scanner scanner = new Scanner(System.in);

		String name = scanner.next();
		String city = scanner.next();
		int age = scanner.nextInt();
		System.out.println(age);
		double weight = scanner.nextDouble();
		System.out.println(name + "/" + city + "/" + age + "/" + weight);
	}
}
