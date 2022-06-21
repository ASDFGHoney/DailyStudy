package HW4;

import java.awt.*;
import javax.swing.*;

public class CalculatorFrame extends JFrame {
	public CalculatorFrame() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new NorthPanel(), BorderLayout.NORTH);
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CalculatorFrame();
	}
}
class SouthPanel extends JPanel {
	public SouthPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JLabel("계산 결과"));
		add(new JTextField(15));
	}
}
class CenterPanel extends JPanel {
	public CenterPanel() {
		setLayout(new GridLayout(5,4,5,5));

		add(new JButton(""));
		JButton del = new JButton("DEL");
		add(del);
		JButton ce = new JButton("CE");
		add(ce);
		JButton d = new JButton("/");
		add(d);
		JButton[] b = new JButton[10];
		for(int i=1; i<10; i++) {
			b[i] = new JButton(Integer.toString(i));
			add(b[i]);
			if(i == 3){
				add(new JButton("x"));
			}
			if(i == 6){
				add(new JButton("+"));
			}
			if(i == 9){
				add(new JButton("-"));
			}
		}
		add(new JButton(""));
		b[0]=new JButton("0");
		add(b[0]);
		JButton dot = new JButton(".");
		add(dot);
		JButton eq = new JButton("=");
		add(eq);

	}
}
class NorthPanel extends JPanel {
	public NorthPanel() {
		setLayout(new FlowLayout());
		add(new JLabel("수식입력"));
		add(new JTextField(16));
	}
}