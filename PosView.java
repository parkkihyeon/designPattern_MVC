package kihyeon.park;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	private JLabel additionLabel = new JLabel("총액 : ");
	private JLabel additionLabel2 = new JLabel("원");
	private JTextField secondNumber = new JTextField(10);
	private JButton calculateButton = new JButton("계산하기");
	private JTextField calcSolution = new JTextField(10);
	private JTextArea JtextHistory = new JTextArea() ;
	private JScrollPane scrollPane = new JScrollPane(JtextHistory, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JTextArea Jtextshowdb = new JTextArea() ;
	private JPanel calcPanel = new JPanel();
	private JButton testButton = new JButton("주문하기");
	private static int windowX = 500, windowY = 600;

	public PosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(windowX, windowY);
		setLayout(new BorderLayout());
	//	calcPanel.add(firstNumber);
	//	calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(additionLabel);
		calcPanel.add(calcSolution);
		calcPanel.add(additionLabel2);
		calcPanel.add(testButton);
		add(calcPanel, BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
		add(Jtextshowdb,BorderLayout.SOUTH);

	//	add(Jtextshowdb,BorderLayout.SOUTH);

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
		Jtextshowdb.setText(db); 
	}
	
	public void setBoard(String board){
		JtextHistory.setText(board);
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
	@Override
	public void updateBoard(String db){
		setBoard(db) ;
	}
}
