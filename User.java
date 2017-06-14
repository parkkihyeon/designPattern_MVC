package kihyeon.park;

public class User{
	private Controller controller ;
	
	User() {
		controller = null ;
	}
	
	public void setController(Controller c){
		controller = c ;
	}
	
	public void setViewByController() {
		controller.updateView();
	}
	
	public void StartCalculateItem(){
		StockProduct guest = new StockProduct() ;
		controller.setNowProduct(guest);
	}
}
