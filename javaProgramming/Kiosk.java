import java.util.Scanner;

public class Kiosk {
    public static void main(String[] args) {
        System.out.println("메뉴판");
        String menu[] = {"에스프레소", "아메리카노", "카페라떼", "카푸치노"};
        int pri[]={1800,2000,2800,3000};

        for(int i = 0; i < 4;i++){
            System.out.print(menu[i]+" : ");
            System.out.println(pri[i]);
        }
        int sum = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("원하는 메뉴를 입력하세요>>");
        
        String inp = scanner.next();
        while(!inp.equals("주문")){
            if(inp.equals("에스프레소")){
                sum+=pri[0];
            }
            else if(inp.equals("아메리카노")){
                sum+=pri[1];
            }
            else if(inp.equals("카페라떼")){
                sum+=pri[2];
            }
            else if(inp.equals("카푸치노")){
                sum+=pri[1];
            }
            else{
                System.out.print("다시해라..");
                break;
            }
            inp = scanner.next();
        }
        System.out.println("전체 금액은"+sum+"원입니다.");
        scanner.close();
    }
}
