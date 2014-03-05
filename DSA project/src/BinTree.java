


public class BinTree {
	Node root;		// keep track of the tree
	Node current;
	Node parent;
	boolean isLeftch=true;
	boolean out=false;
	Node match=null;
	public void insert(Node newNode){
		
		if(root==null){
			root=newNode;
			root.key=root.hashcode(500);	//set root key as 500 by call method
		}
		else {						// if not root
			Node curnt=root;
			Node parnt;
			while (true) {			//travese trough the tree to find correct place and joint to tree
				parnt=curnt;
				if(newNode.getKey()<curnt.getKey()){
					curnt=curnt.leftChld;
					if(curnt== null){
						parnt.leftChld=newNode;					
						return;
					}
					
				}else{
					curnt=curnt.rightChld;
					if(curnt== null){
						parnt.rightChld=newNode;

						return;
					}
				}
			}			
			
		}

	}
	
	public void inOrder(Node tempRoot){
		if (tempRoot!=null) {
			inOrder(tempRoot.leftChld);
			BinTree.printOut(tempRoot);
			inOrder(tempRoot.rightChld);			
		}
	}
	public static void printOut(Node input){
			System.out.println("------------------------------------");
			System.out.println("Book title  :"+input.title);
			System.out.println("Author name :"+input.autFname +" "+input.autLname);
			System.out.println("ISBN is     : "+input.isbn);
			
			
	}
	
	public Node findDelNode(int delKey){
		current=root;				// to keep track of current node
		parent=root;				// to keep track of parent of current node
		while(current.getKey()!=delKey){	//go through tree and search to equal names(using key that generate from title)
			parent=current;
			if(delKey<current.getKey()){	//go to left subtree
				isLeftch=true;
				current=current.leftChld;
			}else{							//or go to right sub tree
				isLeftch=false;
				current=current.rightChld;
			}
			if(current==null){				//if didn't find
				return null;		
			}				
		}			//end of while
		return current;
	}
	
	
	public boolean deleteNode(Node curnt){
		if (curnt.leftChld==null && curnt.rightChld==null) {	//if no child
			if(curnt==root)
				root=null;
			else if(isLeftch)
				parent.leftChld=null;
			else 
				parent.rightChld=null;
		}else if(curnt.rightChld==null){		//no rightchild replace left sub tree
			if(curnt==root)
				root=curnt.leftChld;
			else if(isLeftch)
				parent.leftChld=curnt.leftChld;
			else
				parent.rightChld=curnt.leftChld;
		}else if(curnt.leftChld==null){			//no left child replace right subtree
			if(curnt==root)
				root=curnt.rightChld;
			else if(isLeftch)
				parent.leftChld=curnt.rightChld;
			else
				parent.rightChld=curnt.rightChld;
		}else{									// have left ,right child
			Node sucssesor=getSuccessor(curnt);		//find the best node to replace
			if(curnt==root)
				root=sucssesor;
			else if(isLeftch)
				parent.leftChld=sucssesor;
			else
				parent.rightChld=sucssesor;
			sucssesor.leftChld=curnt.leftChld;
		}
		
		return true;
	}
	
	private Node getSuccessor(Node delNode){
		Node sucsParent=delNode;
		Node sucssr=delNode;
		Node crnt=delNode.rightChld;		//go to right side
		while(crnt!=null){					//Until find node without leftchild
			sucsParent=sucssr;
			sucssr=crnt;
			crnt=crnt.leftChld;				//go to left
		}
		if(sucssr!=delNode.rightChld){
			sucsParent.leftChld=sucssr.rightChld;
			sucssr.rightChld=delNode.rightChld;
		}
		return sucssr;
	}	
	
	public boolean checkISBN(Node temproot,int isbn){		// recursively traverse tree and find the ISBN
		boolean b=false;
		
		if(temproot!=null){	
			
			b=matchISBN(temproot,isbn);		// check ISBN match
			
			if(b==true){				
				out=true;	
				//System.out.println("return it as contain");
				return out;
				
			}
			out=false;
			checkISBN(temproot.leftChld,isbn);		//call recursive and go to left subtree
			checkISBN(temproot.rightChld,isbn);		//call recursive and go to right subtree
		}		
		return out;
	}

	public Node checkISBNDel(Node temproot,int isbn){	//find the node(book object with ISBN
		
		boolean b=false;	
		if(temproot!=null){
			if(temproot.leftChld!=null || temproot.rightChld!=null)
				parent=temproot;				//keep the track of parent of current node
			checkISBNDel(temproot.leftChld,isbn);		// call recursively and go to left subtree
			current=temproot;
			b=matchISBN(current,isbn);		//check if ISBN is contain
			if(b==true){					
					match=current;
					}			
			checkISBNDel(temproot.rightChld,isbn);	// call recursively and go to right subtree
			if(temproot.leftChld!=null || temproot.rightChld!=null)
				parent=temproot;			
		}		
		return match;
	}
	public boolean matchISBN(Node temp,int isbn){
		boolean isContain=false;
		if(temp.getISBN()==isbn){			
			isContain=true;

		}		
		return isContain;
	}
	
	public void printRelate(Node temp,String tag){
		
		if(temp!=null){
			printRelate(temp.leftChld,tag );	// call recursively and go to left subtree
			temp.title=temp.title.toLowerCase();
			int cnt=temp.title.indexOf(tag);		//check for title contain tag
			if(cnt>=0){
				printOut(temp);					// print the tag contain node
			}
			printRelate(temp.rightChld,tag );	// call recursively and go to right subtree
		}
		
	}
}
