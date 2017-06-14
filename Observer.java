package kihyeon.park;

public interface Observer {
	void update(int data) ;
	void update(String db);
	void updateBoard(String db) ;
}
