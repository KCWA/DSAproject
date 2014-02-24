
public class Node {
	String title;
	String autFname;
	String autLname;
	int isbn;
	int key;
	Node leftChld;
	Node rightChld;
	
	public Node(String title, String autFname, String autLname, int isbn,
			int key) {
		
		this.title = title;
		this.autFname = autFname;
		this.autLname = autLname;
		this.isbn = isbn;
		this.key = key;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
	
	
	
}
