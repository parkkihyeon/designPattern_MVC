package kihyeon.park;

import java.util.ArrayList;

public class PosModel {

	ModelData modeldata = new ModelData();
	private ArrayList<Observer> list = new ArrayList<Observer>();

	public void appendHistoryBoard() {
		ArrayList<Integer> list = modeldata.getProductList();

		for (int i = 0; i < modeldata.getProductSizeList(); i++) {
			switch (i) {
			case 0:
				modeldata.appendHistoryBoard("아이스크림 : " + list.get(i) + "개\n");
				break;
			case 1:
				modeldata.appendHistoryBoard("과자 : " + list.get(i) + "개\n");
				break;
			case 2:
				modeldata.appendHistoryBoard("껌 : " + list.get(i) + "개\n");
				break;
			case 3:
				modeldata.appendHistoryBoard("담배 : " + list.get(i) + "개\n");
				break;
			case 4:
				modeldata.appendHistoryBoard("김밥 : " + list.get(i) + "개\n");
				break;
			case 5:
				modeldata.appendHistoryBoard("휴지 : " + list.get(i) + "개\n");
				break;
			case 6:
				modeldata.appendHistoryBoard("물 : " + list.get(i) + "개\n");
				break;
			default:
				break;
			}
		}
		notifyObservers();
	}

	public void CalculateItem() {
		ArrayList<Integer> list = modeldata.getProductList();
		int nowSum = 0;
		int price;
		for (int i = 0; i < modeldata.getProductSizeList(); i++) {
			modeldata.getDataBase().SetItem(i, list.get(i));
			price = modeldata.getDataBase().getPrice(i) * list.get(i);
			modeldata.plusSum(price);
			nowSum += price;
		}
		modeldata.appendHistoryBoard("총액 : " + nowSum + "\n\n");
		notifyObservers();
	}

	public void registerObserver(Observer o) {
		list.add(o);
	}

	public void setNowProduct(StockProduct p) {
		modeldata.setNowProduct(p);
		System.out.println("setProduct");
	}

	// 4. 옵저버들은 업데이트.
	public void notifyObservers() {
		for (Observer o : list) {
			o.update(modeldata);
		}
	}

	public void addStockProduct(int productTypde, int addNum){
		modeldata.getDataBase().SetItem(productTypde, -addNum);
		System.out.println(productTypde + " " + addNum) ;
		notifyObservers();
	}

}
