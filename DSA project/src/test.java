

public class test {

	public static void main(String[] args) {
		BinTree bt=new BinTree();
		Node nod=new Node("java", "man", "test", 120, 50);
		bt.insert(nod);
		
		nod=new Node("php", "ben", "log", 1524, 25);
		bt.insert(nod);
		
		nod=new Node("php help", "benten", "log laf", 1523, 25);
		bt.insert(nod);
		
		nod=new Node("java help", "katty ", "sierra", 1523, 15);
		bt.insert(nod);
		
		nod=new Node("java", "katy ", "Sierra", 1205, 50);
		bt.insert(nod);
		
		nod=new Node("java fx", "katy sys ", "Sierrasdfdf", 1206, 24);
		bt.insert(nod);
		
		nod=new Node("php", "inesh ", "dhanushka", 1205, 60);
		bt.insert(nod);
		
		bt.inOrder(bt.root);
		
		
	}

}
