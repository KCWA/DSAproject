
public class BinTree {
	Node root;
	
	public void insert(Node newNode){
		
		if(root==null){
			root=newNode;
		System.out.println("root inserted"+newNode.key);
		}
		else {
			Node curnt=root;
			Node parnt;
			while (true) {
				parnt=curnt;
				if(newNode.key<curnt.key){
					curnt=curnt.leftChld;
					if(curnt== null){
						parnt.leftChld=newNode;
						System.out.println("inserted"+newNode.key);
						return;
					}
					
				}else{
					curnt=curnt.rightChld;
					if(curnt== null){
						parnt.rightChld=newNode;
						System.out.println("inserted"+newNode.key);
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
	}
}
