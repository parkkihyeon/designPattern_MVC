package kihyeon.park;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class StockView extends JFrame implements Observer {
	static private JFrame frame = new JFrame("구매") ;
	static private JPanel panel = new JPanel() ;
	static private JPanel panel2 = new JPanel() ;
	static private JTextField add_numitem = new JTextField(5) ;
	static private JButton check_button = new JButton("구입") ;
	
	static private Dimension frameSize = frame.getSize() ;
	static private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize() ;
	static private JComboBox comboBox = new JComboBox() ;

	static int sibal = 1 ;
	
	StockView(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocation((screenSize.width - frameSize.width)/3, (screenSize.height-frameSize.height)/4);
		// 프레임을 형성 한 것을 cp 라는 객체에 대입.
		Container cp = frame.getContentPane();
		cp.setLayout(new FlowLayout(1)); 
		comboBox.setModel(new DefaultComboBoxModel<Object>(
				new String[]{"icecream", "snack", "gum", "cigarret", "kimbab", "tissue", "water"	}));
		add_numitem.setText("0");
		
		cp.add(panel);
		cp.add(panel2) ;
		panel.add(comboBox) ;
		panel.add(add_numitem) ;
		panel2.add(check_button) ;
		
		frame.setSize(200,200) ;
		frame.setVisible(true);
		frame.setResizable(false);
	}
	// (String) Stock_gui.getComboBox().getSelectedItem()
	public void StockButtonListener(ActionListener listener){
		check_button.addActionListener(listener) ;
	}
	
	public int getProductAddSize(){
		return Integer.parseInt(add_numitem.getText()) ;
	}
	
	public int getSelectedItem(){
		return comboBox.getSelectedIndex() ;
	}
	
	public void showMessage(){
		JOptionPane.showMessageDialog(null, "구매가 완료 되었습니다.", "구매", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void update(ModelData modelData) {
	}
}