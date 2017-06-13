package kihyeon.park;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PosView extends JFrame implements Observer {

	private JTextField firstNumber = new JTextField(10);
	private JLabel additionLabel = new JLabel("+");
	private JTextField secondNumber = new JTextField(10);
	private JButton calculateButton = new JButton("계산");
	private JTextField calcSolution = new JTextField(10);
	private JTextArea calHistory = new JTextArea() ;
	private JPanel calcPanel = new JPanel();
	private static int windowX = 500, windowY = 500;

	public PosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(windowX, windowY);
		setLayout(new BorderLayout());
		calcPanel.add(firstNumber);
		calcPanel.add(additionLabel);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		add(calcPanel, BorderLayout.NORTH);
		add(calHistory,BorderLayout.CENTER);
	}

	public int getFirstNumber() {
		return Integer.parseInt(firstNumber.getText());
	}

	public int getSecondNumber() {
		return Integer.parseInt(secondNumber.getText());
	}

	public void setResultView(int result) {
		calcSolution.setText(result + "");
	}
	
	public void setHistory(String db){
		calHistory.setText(db); 
	}
	

	public void setPosViewListener(ActionListener listener) {
		calculateButton.addActionListener(listener);
	}

	@Override
	public void update(int data) {
		// 5. 옵저버들이 관리하는 뷰들을 Set한다.
		setResultView(data);
	}
	
	@Override
	public void update(String db) {
		// 5. 옵저버들이 관리하는 뷰들을 Set한다.
		setHistory(db);
	}
}
