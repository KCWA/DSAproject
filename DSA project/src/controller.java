
public class controller {	
	BinTree bn;				
	public controller() {		//constructor create object of BinTree and make link
		bn = new BinTree();
	}

	public boolean inputBook(String title, String autFname, String autLname, int isbn){
		
		boolean bkTypeJv=checkBookCntnt(title, "java");		//check the type of book 
		boolean bkTypeph=checkBookCntnt(title, "php");
		if(bkTypeJv!=false||bkTypeph!=false){				// books contain java or php
				boolean cntainIsbn=bn.checkISBN(bn.root, isbn);		//check isbn is already taken

					if(!cntainIsbn){
								Node newNode=new Node(title, autFname, autLname, isbn);		//create a new object
								bn.insert(newNode);											// add the object to binary tree
						}else
							System.out.println("book ISBN is Already taken");
						
						
						return true;
		}else
			System.out.println("!!!!!!!!!!!!!book dont relate to php or java");
		return false;
		
	}
	public void printAll(){
		System.out.println("******************************current book list***********************************");
		bn.inOrder(bn.root);
	}
	public boolean checkBookCntnt(String name,String type){
		name=name.toLowerCase();		
		int cntn=name.indexOf(type);	//chen if name contain type
		if(cntn>=0)
			return true;
		
		return false;
	}
	
	public void searchName(String name){
		Node n=new Node();
		int hash=n.hashcode(name);		//generate hash code using node class
		n=bn.findDelNode(hash);			
		if(n==null)
			System.out.println("No book named  "+name);
		else if(n.title.equalsIgnoreCase(name))
			BinTree.printOut(n);
		else
			System.out.println("No book named  "+name);
	}
	public void searchISBN(int isbn){
		Node n=new Node();
		n=bn.checkISBNDel(bn.root, isbn);	
		if(n==null)
			System.out.println("No book Contain ISBN  "+isbn);
		else if(n.isbn==isbn)
			BinTree.printOut(n);
		else
			System.out.println("No book Contain ISBN  "+isbn);
		
	}
	public void printRelTag(String tag){
		bn.printRelate(bn.root, tag);		
	}
	public void delByName(String name){
		Node node=new Node();
		int key=node.hashcode(name);	// generate hash code using node class

		node=bn.findDelNode(key);		//Traverse the tree and find the node(book object) return that object
		if(node!=null){
			boolean cnfrm=bn.deleteNode(node);	//send that object to delete
					if(cnfrm){
						BinTree.printOut(node);			//if deleted show the result
						System.out.println("The record is deleted");
					}
					else
						System.out.println("The record deleted");
		}else
			System.out.println("Sorry No book named "+name);
		
	}
	public void delByIsbn(int isbn){
		Node node=new Node();	
		bn.match=null;
		node=bn.checkISBNDel(bn.root, isbn);	//travese in tree and take the object that contain same isbn
		if(node!=null){			
			boolean cnfrm=bn.deleteNode(node);	//send that object to delete
					if(cnfrm){
						BinTree.printOut(node);
						System.out.println("The record is deleted");
						node=null;					
					}
					else
						System.out.println("The record is not deleted");
		}else
			System.out.println("Sorry No book contain "+isbn);	
		node=null;
	}	
	public boolean isEmpty(){
		if(bn.root== null)
			return false;
		else
			return true;
	}
	
}
