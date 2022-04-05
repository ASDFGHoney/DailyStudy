import java.util.Scanner;

public class Dollar2Won {
    public static void main(String[] args) {
        System.out.print("달러를 입력하세요(단위$)>>");
        Scanner scanner = new Scanner(System.in);

        int dollar = scanner.nextInt();
        System.out.print(dollar + "달러는 " + dollar*1100 + "원입니다.");
        scanner.close();
    }
}
