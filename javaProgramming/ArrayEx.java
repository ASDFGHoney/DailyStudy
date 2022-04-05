import java.util.Scanner;

public class ArrayEx {
    
    public static void main(String[] args) {
        //배열 생성
        //int[] intArray = new int[args.length];

        System.out.print("정수를 입력하세요 >>");
        Scanner scanner = new Scanner(System.in);
        int inputI = scanner.nextInt();
        System.out.print(inputI+"보다 큰 정수는 ");

        for(int i=0; i< args.length; i++){
            if(Integer.parseInt(args[i]) > inputI)
                System.out.print(args[i]+" ");
        }

        System.out.print("입니다.");
        scanner.close();
    }
}
