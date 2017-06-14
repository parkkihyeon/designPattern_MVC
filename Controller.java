package kihyeon.park;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controller {

	private PosModel model;
	private MainView view;
	private StockView stockView;
	
	public Controller(PosModel model, MainView view) {
		this.model = model;
		this.view = view;
		model.registerObserver(view);
		view.setMainViewListener(new CalculateListener()) ;
		view.setTestListener(new OrderListener()); 
		reFreshGuest();
	}

	public Controller() {
		this.model = new PosModel();
		this.view = new MainView();
		model.registerObserver(view);
		view.setMainViewListener(new CalculateListener()) ;
		view.setTestListener(new OrderListener()); 
		reFreshGuest();
		System.out.println("controller_post");
	}

	public void updateView() {
		view.setVisible(true);
	}

	public void setNowProduct(StockProduct p) {
		model.setNowProduct(p);
		System.out.println("setProduct");
	}
	
	public void reFreshGuest() {
		setNowProduct(new StockProduct()) ;
		model.appendHistoryBoard() ;
	}
	
	private class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	try {
    			// 2. 모델에게 값을 바꾸라고 요청.	
    			model.CalculateItem();
    			reFreshGuest() ;
    		} catch (RuntimeException e1) {
    			e1.printStackTrace();
    		}
        }
    }
	
	private class OrderListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	try {
        		stockView = new StockView() ;
        		stockView.StockButtonListener(new StockHandler()) ;
    		} catch (RuntimeException e1) {
    			e1.printStackTrace();
    		}
        }
    }
	
	private class StockHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				int productTypde = stockView.getSelectedItem();
				int addNum = stockView.getProductAddSize() ;
				if(addNum > 0 ){
					model.addStockProduct(productTypde, addNum);
					stockView.showMessage() ;
				}
        		
    		} catch (RuntimeException e1) {
    			e1.printStackTrace();
    		}
		}
	}
}