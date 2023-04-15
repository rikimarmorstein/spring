package client;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();

		JFrame fr = new JFrame("Dictionary Application");
		fr.setBounds(100, 100, 1200, 400);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLayout(null);

		JLabel lbEnterWord = new JLabel("enter word: ");
		JTextField tfEnterWord = new JTextField();
		JButton btGetCar = new JButton("Find");
		JTextArea textArea = new JTextArea(0, 1500);

		lbEnterWord.setBounds(10, 10, 150, 25);
		tfEnterWord.setBounds(100, 10, 150, 25);
		btGetCar.setBounds(10, 50, 240, 25);

		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 100, 1000, 150);

		fr.add(lbEnterWord);
		fr.add(tfEnterWord);
		fr.add(btGetCar);
		fr.add(scrollPane);
	}

}
