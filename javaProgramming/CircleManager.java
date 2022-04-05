import java.util.Scanner;

class Circle {
    private String name;
    private double x, y;
    private int radius;

    public Circle(String name, double x, double y, int radius) {
        /* 생성자 작성 */
        this.name = name;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void show() {
        /* Circle 객체의 정보 출력 메소드 작성 */
        System.out.println(this.name + "의 위치는 (" + this.x + "," + this.y + "), 반지름은 " + this.radius);
    }

    public void changePosition(double x, double y) {
        /* Circle 객체의 위치 변경 메소드 작성, 변경된 결과 출력 */
        this.x = x;
        this.y = y;
        System.out.println(this.name + "의 위치가 (" + this.x + "," + this.y + ")로 변경됨");
    }
}

public class CircleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /* 3개의 Circle 객체가 들어가는 배열 생성 */
        String name_;
        double x_, y_;
        int radius_;
        Circle[] c = new Circle[3];
        for (int i = 0; i < c.length; i++) {
            System.out.print(i + "번 원의 이름, x좌표, y좌표, 반지름 입력 >> ");
            /* 입력 받아서 Circle 객체 생성 */
            name_ = scanner.next();
            x_ = scanner.nextDouble();
            y_ = scanner.nextDouble();
            radius_ = scanner.nextInt();
            /* 생성된 객체의 정보 출력 */
            c[i] = new Circle(name_, x_, y_, radius_);
        }
        for (int i = 0; i < c.length; i++) {
            c[i].show();
        }
        int num;
        System.out.print("위치를 바꾸고 싶은 원의 번호와 변경할 x, y 좌표를 입력 하세요 >> ");
        num = scanner.nextInt();
        x_ = scanner.nextDouble();
        y_ = scanner.nextDouble();
        /* 번호와 좌표 입력 받아 해당 객체의 좌표 변경 */
        c[num].changePosition(x_, y_);
        scanner.close();
    }
}