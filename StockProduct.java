package kihyeon.park;

import java.util.ArrayList;
import java.util.Random;

public class StockProduct {
	ArrayList<Integer> buyingProduct = new ArrayList<Integer>() ;
	private final static int DATASIZE = 7 ;
	private final static int MAX_NUMOFDATA = 5 ;
	
	StockProduct() {
		Random randomNumber = new Random() ;
		for (int i = 0 ; i < DATASIZE ; i++) {
			buyingProduct.add(randomNumber.nextInt(MAX_NUMOFDATA)) ;
		}
	}
	
	public ArrayList<Integer> getProductList(){
		return buyingProduct ;
	}
	
	public int getDataSize(){
		return DATASIZE ;
	}
}
