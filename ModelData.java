package kihyeon.park;

import java.util.ArrayList;

public class ModelData {
	private int sumTotalMoney = 0;
	private ProductDatabase database = new ProductDatabase() ;
	private String histroyBoard = "" ;
	private String test = "물건 구매하기" ;
	private StockProduct nowProduct ;
	
	public int getSum(){
		return sumTotalMoney ;
	}
	
	public ArrayList<Integer> getProductList(){
		return nowProduct.getProductList() ;
	}
	
	public ProductDatabase getDataBase(){
		return database ;
	}
	
	public String getHistoryBoard(){
		return histroyBoard ;
	}
	
	public String getTest(){
		return test ;
	}
	
	public StockProduct getNowProduct(){
		return nowProduct ;
	}
	
	public int getProductSizeList(){
		return nowProduct.getDataSize() ;
	}
	
	public void setSum(int s){
		sumTotalMoney = s ;
	}
	
	public void plusSum(int sum){
		sumTotalMoney += sum ;
	}
	
	public void setHistoryBoard(String board){
		histroyBoard = board ;
	}
	
	public void appendHistoryBoard(String board){
		histroyBoard+= board ;
	}
	
	public void setTest(String t){
		test = t ;
	}
	
	public void setNowProduct(StockProduct p){
		nowProduct = p;
	}
		
}
