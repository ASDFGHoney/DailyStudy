import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//TODO 액티비티에 ActionListener 클릭 이벤트 상속 받음
public class MainActivity13 extends JFrame implements ActionListener{

	//TODO 전역 변수 선언 실시
	static String[] arr = {
			"0","1","2","*",
			"3","4","5","/",
			"6","7", "8","+",
			"9","CE","=","-"
	};

	static JButton[] btn = new JButton[16];
	static JLabel calc_txt;
	static JLabel result_txt;
	static MainActivity13 mainActivity;

	static String total_data = "";

	//TODO 메인 메소드 시작 부분
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[GUI (awt/swing) - 사칙 연산 계산기 프로그램 만들기]");

		/*[설 명]
		 * 1. 자바에서는 JFrame을 사용해서 GUI 프로그램을 만들 수 있습니다
		 * 2. new GridLayout(행, 열, 가로여백, 세로여백) 표시 - 테이블 모양 형식
		 * 3. ActionListener : 클릭 이벤트 정의 실시
		 * 4. for문 : 동적으로 배열에 포함된 값을 사용해 버튼을 생성합니다
		 * */

		//TODO 클릭 이벤트를 정의하기 위해 액티비티 객체 생성
		mainActivity = new MainActivity13();

		//TODO 부모 프레임 생성
		JFrame frm = new JFrame("계산기 프로그램");

		//TODO 부모 프레임 크기 설정 (가로, 세로)
		frm.setSize(500, 500);

		//TODO 부모 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);

		//TODO 부모 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//TODO 부모 프레임 창 크기 고정 실시
		frm.setResizable(false);

		//TODO 부모 레이아웃 설정
		frm.getContentPane().setLayout(null);

		//TODO 자식 레이아웃 [텍스트] 생성
		calc_txt = new JLabel("0");
		calc_txt.setBounds(0, 0, 500, 100); //TODO setBounds(가로위치, 세로위치, 가로길이, 세로길이);
		calc_txt.setOpaque(true); //TODO setBackground 적용하기 위한 선행 설정
		calc_txt.setBackground(Color.GRAY); //TODO 백그라운드 색상 정의
		calc_txt.setForeground(Color.WHITE); //TODO 텍스트 색상 정의
		calc_txt.setFont(new Font("맑은 고딕", 0, 20)); //TODO 폰트 정의
		calc_txt.setHorizontalAlignment(JLabel.CENTER); //TODO 텍스트 센터 표시 설정

		//TODO 자식 레이아웃 [텍스트] 생성
		result_txt = new JLabel("result");
		result_txt.setBounds(0, 100, 500, 50); //TODO setBounds(가로위치, 세로위치, 가로길이, 세로길이);
		result_txt.setOpaque(true); //TODO setBackground 적용하기 위한 선행 설정
		result_txt.setBackground(Color.darkGray); //TODO 백그라운드 색상 정의
		result_txt.setForeground(Color.WHITE); //TODO 텍스트 색상 정의
		result_txt.setFont(new Font("맑은 고딕", 0, 20)); //TODO 폰트 정의
		result_txt.setHorizontalAlignment(JLabel.CENTER); //TODO 텍스트 센터 표시 설정

		//TODO 자식 레이아웃 [버튼] 생성
		JPanel grid_panel = new JPanel();
		grid_panel.setLayout(new GridLayout(4, 4, 0, 0)); //테이블 형식 - 행, 열, 가로 여백, 세로 여백

		for(int idx=0; idx<arr.length; idx++) {
			btn[idx] = new JButton(arr[idx]);
			btn[idx].setFont(new Font("맑은 고딕", 0, 20)); //TODO 폰트 정의
			if(arr[idx].contains("*") || arr[idx].contains("/") ||
					arr[idx].contains("+") || arr[idx].contains("-")) {
				btn[idx].setBackground(Color.BLACK); //TODO 백그라운드 색상 정의
			}
			else if(arr[idx].contains("CE") || arr[idx].contains("=")) {
				btn[idx].setBackground(Color.darkGray); //TODO 백그라운드 색상 정의
			}
			else {
				btn[idx].setBackground(Color.GRAY); //TODO 백그라운드 색상 정의
			}
			btn[idx].setForeground(Color.WHITE); //TODO 텍스트 색상 정의
			btn[idx].addActionListener(mainActivity); //TODO 클릭 이벤트 추가

			grid_panel.add(btn[idx]); //TODO JPanel에 버튼 추가

		}
		grid_panel.setBounds(0, 150, 500, 320); //TODO setBounds(가로위치, 세로위치, 가로길이, 세로길이);

		//TODO 부모 프레임에다가 자식 컴포넌트 추가
		frm.getContentPane().add(calc_txt);
		frm.getContentPane().add(result_txt);
		frm.getContentPane().add(grid_panel);

		//TODO 부모 프레임이 보이도록 설정
		frm.setVisible(true);

	}//메인 종료

	//TODO 버튼 클릭 이벤트 수행 부분
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO Auto-generated method stub

		//TODO 컴포넌트에 정의된 text 받아오는역할
		switch(e.getActionCommand()){

			//TODO getActionCommand() 버튼의 텍스트를 얻어옵니다
			case "0":
				total_data += "0";
				calc_txt.setText(total_data);
				break;

			case "1":
				total_data += "1";
				calc_txt.setText(total_data);
				break;

			case "2":
				total_data += "2";
				calc_txt.setText(total_data);
				break;

			case "3":
				total_data += "3";
				calc_txt.setText(total_data);
				break;

			case "4":
				total_data += "4";
				calc_txt.setText(total_data);
				break;

			case "5":
				total_data += "5";
				calc_txt.setText(total_data);
				break;

			case "6":
				total_data += "6";
				calc_txt.setText(total_data);
				break;

			case "7":
				total_data += "7";
				calc_txt.setText(total_data);
				break;

			case "8":
				total_data += "8";
				calc_txt.setText(total_data);
				break;

			case "9":
				total_data += "9";
				calc_txt.setText(total_data);
				break;

			case "*":
				total_data += "*";
				calc_txt.setText(total_data);
				break;

			case "/":
				total_data += "/";
				calc_txt.setText(total_data);
				break;

			case "+":
				total_data += "+";
				calc_txt.setText(total_data);
				break;

			case "-":
				total_data += "-";
				calc_txt.setText(total_data);
				break;

			case "CE":
				total_data = "";
				calc_txt.setText("0");
				result_txt.setText("result");
				break;

			case "=":
				if(total_data != null && total_data.length() > 0) {
					int data = calc(total_data);
					result_txt.setText(String.valueOf(data));
				}
				else {
					result_txt.setText("result");
				}
				break;

			default :
				calc_txt.setText("NO");
				break;
		}
	}

	//TODO 사칙 연산을 수행하는 재귀 메소드
	public static int calc(String input) {
		int idx;
		idx = input.indexOf('+'); //TODO [+] 문자의 인덱스 위치 확인

		if (idx != -1) { //TODO [+] 문자가 있으니까 -1이 아니여야 함 (indexOf는 찾을려는 문자가 없으면 -1 반환)
			return calc(input.substring(0, idx)) + calc(input.substring(idx + 1));
		}
		else { //TODO [+] 문자가 없을 경우는 [-], [*], [/] 연산자 포함 여부를 확인합니다
			idx = input.indexOf('-');
			if (idx != -1) {
				return calc(input.substring(0, idx)) - calc(input.substring(idx + 1));
			}
			else {
				idx = input.indexOf('*');
				if (idx != -1) {
					return calc(input.substring(0, idx)) * calc(input.substring(idx + 1));
				}
				else {
					idx = input.indexOf('/');
					if (idx != -1) {
						return calc(input.substring(0, idx)) / calc(input.substring(idx + 1));
					}
				}
			}
		}

		String data = input.trim();
		if (data == null || data.isEmpty()) {
			return 0;
		}

		return Integer.parseInt(data);
	}

}//클래스 종료
