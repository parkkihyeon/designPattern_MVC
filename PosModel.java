package kihyeon.park;

import java.util.ArrayList;

public class PosModel {
	private int sum = 0;
	private ArrayList<Observer> list = new ArrayList<Observer>();
	private ProductDatabase database = new ProductDatabase() ;
	private String histroyBoard = "" ;
	
//	public void addTwoNumber(int price) {
//		sum += price;
//		// 3. 값을 바꾼 후 옵저버에게 알림
//		notifyObservers();
//	}
	public void appendHistoryBoard(StockProduct p){
		ArrayList<Integer> list = p.getProductList() ;
		for(int i = 0 ; i < p.getDataSize(); i++ ){
			switch(i){
			case 0:
				histroyBoard += "아이스크림 : " + list.get(i) + "개\n" ;
				break ;
			case 1:
				histroyBoard += "과자 : " + list.get(i) + "개\n" ;
				break ;
			case 2:
				histroyBoard += "껌 : " + list.get(i) + "개\n" ;
				break ;
			case 3:
				histroyBoard += "담배 : " + list.get(i) + "개\n" ;
				break ;
			case 4:
				histroyBoard += "김밥 : " + list.get(i) + "개\n" ;
				break ;
			case 5:
				histroyBoard += "휴지 : " + list.get(i) + "개\n" ;
				break ;
			case 6:
				histroyBoard += "물 : " + list.get(i) + "개\n" ;
				break ;
			default :
				break ;
			}
		}
		notifyObserversBoard() ;
	}
	
	public void CalculateItem(StockProduct p){
		ArrayList<Integer> list = p.getProductList() ;
		int nowSum = 0 ;
		int price ;
		for(int i = 0 ; i < p.getDataSize(); i++ ){
			database.SetItem(i, list.get(i));
			price = database.getPrice(i) * list.get(i) ; 
			sum += price ;
			nowSum += price ; 
		}
		histroyBoard += "총액 : " + nowSum + "\n\n" ; 
		notifyObservers();
		notifyObserversBoard() ;
	}
	
	public void registerObserver(Observer o) {
		list.add(o);
	}

	// 4. 옵저버들은 업데이트.
	
	public void notifyObserversBoard() {
		for (Observer o : list) {
			o.updateBoard(histroyBoard) ;
		}
	}
	
	public void notifyObservers() {
		for (Observer o : list) {
			o.update(sum);
			o.update("재고 현황\n"+database.Show_DB());
		}
	}
	
}
