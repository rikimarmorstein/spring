package a;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonProgram {

	public static void main(String[] args) {

		JFrame fr = new JFrame("button programming");
		fr.setLayout(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setBounds(100, 100, 600, 300);

		JButton button = new JButton("click");

		button.setBounds(100, 100, 150, 25);
		fr.add(button);
//		MyActionListener listener = new MyActionListener();
//		button.addActionListener(listener);
//		button.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("clicked");
//			}
//		});
		// lambda
		ActionListener listener = e -> System.out.println("clicked lambda");
		button.addActionListener(listener);
//		button.addActionListener(e -> System.out.println("clicked lambda"));
//		fr.setVisible(true);

	}

}
