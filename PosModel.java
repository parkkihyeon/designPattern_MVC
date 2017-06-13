package kihyeon.park;

import java.util.ArrayList;

public class PosModel {
	private int data;
	private ArrayList<Observer> list = new ArrayList<Observer>();
	private ProductDatabase database = new ProductDatabase() ;
	
	public void addTwoNumber(int firstNumber, int secondNumber) {
		data = firstNumber + secondNumber;
		// 3. 값을 바꾼 후 옵저버에게 알림
		notifyObservers();
	}

	public void registerObserver(Observer o) {
		list.add(o);
	}

	// 4. 옵저버들은 업데이트.
	public void notifyObservers() {
		for (Observer o : list) {
			o.update(data);
			o.update(database.Show_DB());
		}
	}
	
	public void Show_DB(){
		System.out.println(database.Show_DB()) ;
	}
}
