package week14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problem4 extends JFrame {
	private JTextArea ta = new JTextArea(4,7);
	private String[] comboItem = {"Java", "Data Structure", "OS"};
	private String[] comboItemDescription={"Java is a 2-1 class", "Data sturcture is a 2-1 class", "OS is a 3-1 class"};
	private JComboBox<String> combo  = new JComboBox<String>(comboItem);

	public Problem4(){
		setTitle("Problem4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		combo.addActionListener(new ComboActionListener());
		ta.setText(comboItemDescription[0]);

		c.add(combo, BorderLayout.NORTH);
		c.add(ta);

		setSize(300,300);
		setVisible(true);
	}

	class ComboActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int index = combo.getSelectedIndex();
			ta.setText(comboItemDescription[index]);
		}
	}

	public static void main(String[] args){
		new Problem4();
	}
}
