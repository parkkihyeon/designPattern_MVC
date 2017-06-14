package kihyeon.park;

public class Main {

	public static void main(String[] args) {
		User kihyeon = new User();
		Controller controller = new Controller();
		kihyeon.setController(controller);
		kihyeon.StartCalculateItem();
		kihyeon.setViewByController();
	}
}
