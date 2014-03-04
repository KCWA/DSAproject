public class controller {
  BinTree bn;	
	public controller() {		
		bn = new BinTree();
	}
	public boolean inputBook(String title, String autFname, String autLname, int isbn){
		
		boolean bkTypeJv=checkBookCntnt(title, "java");
		boolean bkTypeph=checkBookCntnt(title, "php");
		if(bkTypeJv!=false||bkTypeph!=false){
			//System.out.println("==============book contain java or php"+isbn);
		
				boolean cntainIsbn=bn.checkISBN(bn.root, isbn);
//					System.out.println("checking isbn--------        "+isbn+cntainIsbn);
					if(!cntainIsbn){
								Node newNode=new Node(title, autFname, autLname, isbn);
								bn.insert(newNode);
						}else
							System.out.println("book already have isbn");
						
						
						return true;
		}else
			System.out.println("!!!!!!!!!!!!!book dont relate to php or java");
		return false;
		
	}
	public void printAll(){
		System.out.println("******************************current book list***********************************");
		bn.inOrder(bn.root);
	}
	public void searchName(String name){
		Node n=new Node();
		int hash=n.hashcode(name);
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
			System.out.println("No book named  "+isbn);
		else if(n.isbn==isbn)
			BinTree.printOut(n);
		else
			System.out.println("No book named  "+isbn);
		
	}
	public void printRelTag(String tag){
		bn.printRelate(bn.root, tag);		
	}
	public void delByName(String name){
        Node node=new Node();
        int key=node.hashcode(name);
        System.out.println(key);
        node=bn.findDelNode(key);
        if(node!=null){
            boolean cnfrm=bn.deleteNode(node);
                    if(cnfrm){
                        BinTree.printOut(node);
                        System.out.println("The record is deleted");
                    }
                    else
                        System.out.println("The record deleted");
        }else
            System.out.println("Sorry No book named "+name);
       
    }
    public void delByIsbn(int isbn){
        Node node=new Node();       
        node=bn.checkISBNDel(bn.root, isbn);
        if(node!=null){
            boolean cnfrm=bn.deleteNode(node);
                    if(cnfrm){
                        BinTree.printOut(node);
                        System.out.println("The record is deleted");
                    }
                    else
                        System.out.println("The record deleted");
        }else
            System.out.println("Sorry No book contain "+isbn);
       
   
    }
}
