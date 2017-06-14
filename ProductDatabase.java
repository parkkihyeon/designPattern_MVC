package kihyeon.park;

import java.util.Vector;

public class ProductDatabase {
	public static enum product{icecream, snack, gum, cigarret, kimbab, tissue, water} ; 
	private static int num_of_product = 7 ;

	static private int []price = {1000,2000,500,4500,2500,700,600} ;
	static private int []num_of_item = {100,100,100,100,100,100,100} ;
	
	static int getIce_price(){	return price[product.icecream.ordinal()] ;}
	static int getSnack_price(){return price[product.snack.ordinal()] ;}
	static int getGum_price(){	return price[product.gum.ordinal()] ;}
	static int getCi_price(){return price[product.cigarret.ordinal()] ;}
	static int getKim_price(){	return price[product.kimbab.ordinal()] ;}
	static int getTis_price(){	return price[product.tissue.ordinal()] ;}
	static int getWater_price(){return price[product.water.ordinal()] ;}
	static int getElementPrice(int index){ return price[index] ; }
	static int getNum_of_product(){return num_of_product ; }
	static int getPrice(int product) { return price[product] ; }
	
	static void Setnum_Icecream(int num) { num_of_item[product.icecream.ordinal()] -= num ; }
	static void Setnum_Snack(int num) { num_of_item[product.snack.ordinal()] -= num ;}
	static void Setnum_Gum(int num) { num_of_item[product.gum.ordinal()] -= num ;}
	static void Setnum_cigarret(int num) { num_of_item[product.cigarret.ordinal()] -= num ;}
	static void Setnum_kimbab(int num) { num_of_item[product.kimbab.ordinal()] -= num ;}
	static void Setnum_tissue(int num) { num_of_item[product.tissue.ordinal()] -= num ;}
	static void Setnum_water(int num) { num_of_item[product.water.ordinal()] -= num ;}
	public static void SetItem(int Item, int num)
	{
		switch(Item)
		{
		case 0 :
			Setnum_Icecream(num) ;
			break ;
		case 1 :
			Setnum_Snack(num) ;
			break ;
		case 2 :
			Setnum_Gum(num) ;
			break ;
		case 3 :
			Setnum_cigarret(num) ;
			break ;
		case 4 :
			Setnum_kimbab(num) ;
			break ;
		case 5 :
			Setnum_tissue(num) ;
			break ;
		case 6 :
			Setnum_water(num);
			break ;
		}
		
	}
	
	public static String Show_DB(){
		StringBuffer Show = new StringBuffer().append(" ") ;
		String temp ;
		
		Show.append(" icecream : " + num_of_item[0]+"\n") ;
		Show.append(" snack : " + num_of_item[1]+"\n") ;
		Show.append(" gum : " + num_of_item[2]+"\n") ;
		Show.append(" cigarret : " + num_of_item[3]+"\n") ;
		Show.append(" kimbab : " + num_of_item[4]+"\n") ;
		Show.append(" tissue : " + num_of_item[5]+"\n") ;
		Show.append(" water : " + num_of_item[6]+"\n") ;
		temp = Show.toString() ;
		return temp ;
	}
}
