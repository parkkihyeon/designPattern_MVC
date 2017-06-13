package kihyeon.park;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private PosModel model;
	private PosView view;

	public Controller(PosModel model, PosView view) {
        this.model = model;
        this.view = view;
		model.registerObserver(view) ;
        this.view.setPosViewListener(this);
    }
	
	public Controller() {
        this.model = new PosModel();
        this.view = new PosView();
		model.registerObserver(view);
        this.view.setPosViewListener(this);
    }

	public void updateView() {
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// 1. 이벤트가 발생했을 때,
		try {
			int firstNumber = view.getFirstNumber();
	        int secondNumber = view.getSecondNumber();
	        // 2. 모델에게 값을 바꾸라고 요청.
			model.addTwoNumber(firstNumber, secondNumber);
			System.out.println("actionPerformed");

		} catch (RuntimeException e) {

		}
	}
}