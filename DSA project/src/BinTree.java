
public class BinTree {
	Node root;
	
	public void insert(Node newNode){
		
		if(root==null){
			root=newNode;
			root.key=root.hashcode(500);
		System.out.println("root inserted  "+newNode.key);  //just for check weather work or not
		}
		else {
			Node curnt=root;
			Node parnt;
			while (true) {
				parnt=curnt;
				if(newNode.getKey()<curnt.getKey()){
					curnt=curnt.leftChld;
					if(curnt== null){
						parnt.leftChld=newNode;
						System.out.println("inserted "+newNode.key+ "============");  //just for check weather work or not
						return;
					}
					
				}else{
					curnt=curnt.rightChld;
					if(curnt== null){
						parnt.rightChld=newNode;
						System.out.println("inserted"+newNode.key+"============");  //just for check weather work or not
						return;
					}
				}
			}			
			
		}
		System.out.println("inserted"+newNode.key);
	}
	
	public void inOrder(Node tempRoot){
		if (tempRoot!=null) {
			inOrder(tempRoot.leftChld);
			BinTree.printOut(tempRoot);
			inOrder(tempRoot.rightChld);			
		}
	}
	public static void printOut(Node input){
			System.out.println(input.title +"and aurthur"+input.autFname+input.autLname);
			System.out.println("isbn is "+input.isbn);
			System.out.println("Key is "+input.key);
			
	}
	Node current;
	Node parent;
	boolean isLeftch=true;;
	public Node findDelNode(int delKey){
		current=root;
		parent=root;
		//isLeftch=true;
		while(current.getKey()!=delKey){	//go through it and search
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
			Node sucssesor=getSuccessor(curnt);
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
		while(crnt!=null){					//untill find node without leftchild
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
	
	boolean out=false;
	public boolean checkISBN(Node temproot,int isbn){
		boolean b=false;
		
		if(temproot!=null){			
			b=matchISBN(temproot,isbn);
			if(b==true){				
				out=true;			
				return out;
			}			
			checkISBN(temproot.leftChld,isbn);
			checkISBN(temproot.rightChld,isbn);
		}
		return out;
	}
	Node match;
	public Node checkISBNDel(Node temproot,int isbn){
		boolean b=false;	
		if(temproot!=null){
			if(temproot.leftChld!=null || temproot.rightChld!=null)
				parent=temproot;
			checkISBNDel(temproot.leftChld,isbn);	
			current=temproot;
			System.out.println("come to chek func current is "+current.getISBN());
			b=matchISBN(current,isbn);
			System.out.println("isbn is "+temproot.isbn);
			if(b==true){
				
					match=current;
					System.out.println("isbn is------------- "+temproot.isbn);
			}
			
			checkISBNDel(temproot.rightChld,isbn);	
			if(temproot.leftChld!=null || temproot.rightChld!=null)
				parent=temproot;
			
		}
		return match;
	}
	public boolean matchISBN(Node temp,int isbn){
		boolean isContain=false;
		if(temp.getISBN()==isbn){			
			isContain=true;
			System.out.println("=============== isbn matched  "+isContain);
		}		
		return isContain;
	}
	
	public void printRelate(Node temp,String tag){
		
		if(temp!=null){
			printRelate(temp.leftChld,tag );
			
			int cnt=temp.title.indexOf(tag);
			if(cnt>=0){
				System.out.println(temp.title);
			}
			printRelate(temp.rightChld,tag );
		}
		
	}
}