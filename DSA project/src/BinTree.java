
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
	Node current=root;
	Node parent=root;
	boolean isLeftch=true;
	public Node findDelNode(int delKey){
		
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
	
	
	public boolean delete(Node current){
		if(current.leftChld==null&& current.rightChld==null){	// if node is leaf
			if(current==root)
				root=null;
			else if(isLeftch)
				parent.leftChld=null;
			else
				parent.rightChld=null;
		}else if(current.rightChld==null){	//if right child is null,replace leftsubtree
			if(current==root)
				root=current.leftChld;
			else if(isLeftch)				//left child of parent
				parent.leftChld=current.leftChld;
			else							//right child of parent
				parent.leftChld=current.rightChld;
		}else if(current.rightChld==null){  //if left child is null,replace rightsubtree
			if(current==root)
				root=current.rightChld;
			else if(isLeftch)
				parent.leftChld=current.rightChld;
			else
				parent.rightChld=current.rightChld;				
		}else{								// has two children
			Node successor=getSuccessor(current);		//call the function to find successor
			if(current==root)
				root=successor;
			else if(isLeftch)
				parent.leftChld=successor;
			else
				parent.rightChld=successor;
			successor.leftChld=current.leftChld;
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
}
