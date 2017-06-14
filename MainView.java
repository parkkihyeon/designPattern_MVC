package kihyeon.park;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainView extends JFrame implements Observer {

	private JLabel additionLabel = new JLabel("총액 : ");
	private JLabel additionLabel2 = new JLabel("원");
	private JButton calculateButton = new JButton("계산하기");
	private JTextField calcSolution = new JTextField(10);
	private JTextArea JtextHistory = new JTextArea() ;
	private JScrollPane scrollPane = new JScrollPane(JtextHistory, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JTextArea Jtextshowdb = new JTextArea() ;
	private JPanel calcPanel = new JPanel();
	private JButton testButton = new JButton("주문하기");
	private static int windowX = 500, windowY = 600;

	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(windowX, windowY);
		setLayout(new BorderLayout());
		calcSolution.setEditable(false);
		JtextHistory.setEditable(false);
		Jtextshowdb.setEditable(false);
		calcPanel.add(calculateButton);
		calcPanel.add(additionLabel);
		calcPanel.add(calcSolution);
		calcPanel.add(additionLabel2);
		calcPanel.add(testButton);
		add(calcPanel, BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
		add(Jtextshowdb,BorderLayout.SOUTH);

	}

	public void setResultView(int result) {
		calcSolution.setText(result + "");
	}
	
	public void setDB(String db){
		Jtextshowdb.setText(db); 
	}
	
	public void setBoard(String board){
		JtextHistory.setText(board);
	}

	public void setTestButton(String board){
		testButton.setText(board);
	}

	
	public void setMainViewListener(ActionListener listener){
		calculateButton.addActionListener(listener);
	}
	
	public void setTestListener(ActionListener listener){
		testButton.addActionListener(listener);
	}
	
	@Override
	public void update(ModelData modelData){
		setResultView(modelData.getSum());
		setDB(modelData.getDataBase().Show_DB());
		setBoard(modelData.getHistoryBoard()) ;
		setTestButton(modelData.getTest()) ;
	}

}
