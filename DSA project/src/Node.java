
public class Node {
	String title;
	String autFname;
	String autLname;
	int isbn;
	int key;
	Node leftChld;
	Node rightChld;
	
	public Node(String title, String autFname, String autLname, int isbn) {
		
		this.title = title;
		this.autFname = autFname;
		this.autLname = autLname;
		this.isbn = isbn;
		this.key = hashcode(title);
	}
	private int hashcode(String name) {
		int hash=500;
		name=name.toLowerCase();
		int len=name.length();
		int cnt=name.indexOf("java");
		int c0=name.indexOf("a");
		if(cnt>=0){
			System.out.println("book contain java "+cnt);
			hash-=cnt;
			hash=hash-len-c0;
		}else{
			cnt=name.indexOf("php");
			if(cnt>=0){
				System.out.println("book contain php "+cnt);
				hash+=cnt;
				hash=hash+len+c0;
			}else{
				System.out.println("book contain other "+cnt);
				hash+=500;
			}
		}
		return hash;
	}
	public int getKey() {
		return key;
	}	
	
	public int hashcode(int i){
		return i;
	}
	
}
