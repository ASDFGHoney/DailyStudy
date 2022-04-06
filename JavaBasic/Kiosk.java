import java.util.Scanner;

class Menu {
	String name;
	int price;
	int box;
	int temp;

	public Menu(String name, int price, int box) {
		this.name = name;
		this.price = price;
		this.box = box;
		this.temp = 0;
	}

	public int getBox() {
		return box - temp;
	}

	public void setBox() {
		box -= temp;
		temp = 0;
	}
}

public class Kiosk {

	public static void main(String[] args) {
		System.out.println("송치헌/컴퓨터공학과/12171637");
		Scanner scanner = new Scanner(System.in);
		System.out.println("[키오스크 초기화]");
		System.out.print("판매하고자하는 메뉴 종류 수를 입력하세요 >> ");
		int numOfMenu = scanner.nextInt();
		Menu[] m;
		m = new Menu[numOfMenu];
		for (int i = 0; i < numOfMenu; i++) {
			System.out.print("판매하고자하는 " + i + "번 메뉴 이름, 가격, 재고를 입력하세요(예: 아메리카노 2000 10) >> ");
			m[i] = new Menu(scanner.next(), scanner.nextInt(), scanner.nextInt());
		}
		System.out.println("[초기화 완료]");
		System.out.println("----------------------------");

		while (true) {
			System.out.println("메뉴판");

			for (int i = 0; i < numOfMenu; i++) {
				System.out.println(m[i].name + " : " + m[i].price + "원(재고:" + m[i].box + ")");
			}

			System.out.print("원하는 메뉴를 입력하세요(띄어쓰기로 메뉴 구분, 마지막에는 '주문' 입력) >> ");

			String input = scanner.next();
			if (input.equals("종료")) {
				System.out.println("종료되었습니다.");
				break;
			} else if (input.equals("재고관리")) {
				System.out.println("----------------------------");
				System.out.println("[관리자모드]");
				while (true){
					System.out.print("관리자 모드를 나가려면 '종료', 재고 변경을 원하시면 메뉴 이름을 입력하세요 >> ");
					input = scanner.next();
					if(input.equals("종료")){
						System.out.println("----------------------------");
						break;
					}
					for (int i = 0; i < numOfMenu; i++) {
						if (input.equals(m[i].name)) {
							System.out.print(m[i].name+"의 재고는 현재 "+m[i].box+"입니다. 변경을 원하시는 수량을 입력하세요 >> ");
							m[i].box+=scanner.nextInt();
						}
					}
				}
			} else {
				int sum = 0;
				boolean isNoBox = false;


				while (!input.equals("주문")) {
					for (int i = 0; i < numOfMenu; i++) {
						if (input.equals(m[i].name)) {
							if (m[i].getBox() == 0) {
								isNoBox = true;
							} else {
								m[i].temp++;
								sum += m[i].price;
							}
						}
					}
					input = scanner.next();
				}


				if (isNoBox) {
					for (int i = 0; i < numOfMenu; i++){
						m[i].temp = 0;
					}
					System.out.println("재고가 부족한 상품이 있습니다. 다시 주문해주세요.");
					System.out.println("----------------------------");
				} else {
					for (int i = 0; i < numOfMenu; i++){
						m[i].setBox();
					}
					System.out.println("전체 금액은 "+sum+"원 입니다.");
					System.out.println("----------------------------");
				}
			}

		}

		scanner.close();
	}
}
