

public class Node  {
	String title;
	String autFname;
	String autLname;
	int isbn;
	int key;		// to store by name ,generate number from title
	Node leftChld;
	Node rightChld;
	
	public Node(String title, String autFname, String autLname, int isbn) {			
		
		this.title = title;
		this.autFname = autFname;
		this.autLname = autLname;
		this.isbn = isbn;
		this.key = hashcode(title);
	}
	public Node() {			//Default constructor
		
	}
	public int hashcode(String name) {		// generate unique number for each  book 
		int hash=500;
		name=name.toLowerCase();
		int len=name.length();
		int cnt=name.indexOf("java");
		int c0=name.indexOf("a");
		if(cnt>=0){
//			System.out.println("book contain java "+cnt);
			hash-=cnt;
			hash=hash-len-c0;
		}else{
			cnt=name.indexOf("php");
			if(cnt>=0){
//				System.out.println("book contain php "+cnt);
				hash+=cnt;
				hash=hash+len+c0;
			}else{
//				System.out.println("book contain other "+cnt);
				hash+=500;
			}
		}
		return hash;
	}
	public int getKey() {
		return key;
	}	
	
	public int hashcode(int i){				//for root of the tree
		return i;
	}
	
	public int getISBN(){
		return isbn;
	}
}
