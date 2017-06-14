package kihyeon.park;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private PosModel model;
	private PosView view;
	private StockProduct nowProduct ;

	public Controller(PosModel model, PosView view) {
		this.model = model;
		this.view = view;
		nowProduct = null ;
		model.registerObserver(view);
		this.view.setPosViewListener(this);
		reFreshGuest();
	}

	public Controller() {
		this.model = new PosModel();
		this.view = new PosView();
		nowProduct = null ;
		model.registerObserver(view);
		this.view.setPosViewListener(this);
		reFreshGuest();
		System.out.println("controller_post");
	}

	public void updateView() {
		view.setVisible(true);
	}

	public void setNowProduct(StockProduct p) {
		nowProduct = p ;
		System.out.println("setProduct");
	}
	
	public void reFreshGuest() {
		setNowProduct(new StockProduct()) ;
		model.appendHistoryBoard(nowProduct) ;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// 1. 이벤트가 발생했을 때,
		try {
			//int firstNumber = view.getFirstNumber();
		//	int price = view.getSecondNumber();
			// 2. 모델에게 값을 바꾸라고 요청.
			
			model.CalculateItem (nowProduct);
			System.out.println("actionPerformed");
			reFreshGuest() ;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}