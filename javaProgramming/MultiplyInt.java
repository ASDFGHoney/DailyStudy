import java.util.Scanner;

public class MultiplyInt {
    public static void main(String[] args) {
        System.out.print("곱하고자 하는 두 수 입력>> ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.print(n + "x" + m + "=" + n * m);
        scanner.close();
    }
}
