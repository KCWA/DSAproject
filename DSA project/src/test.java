

public class test {

	public static void main(String[] args) {
		BinTree bt=new BinTree();
		Node nod=new Node("java programing", "man", "test", 120);
		bt.insert(nod);
		
		nod=new Node(" help php", "ben", "log", 1524);
		bt.insert(nod);
		
		nod=new Node("php help", "benten", "log laf", 1523);
		bt.insert(nod);
		
		nod=new Node("java help", "katty ", "sierra", 1523);
		bt.insert(nod);
		
		nod=new Node("java", "katy ", "Sierra", 1205);
		bt.insert(nod);
		
		nod=new Node("java fx", "katy sys ", "Sierrasdfdf", 1206);
		bt.insert(nod);
		
		nod=new Node("php", "inesh ", "dhanushka", 1205);
		bt.insert(nod);
		nod=new Node("php with html", "ineshda ", "gundhanushka", 1255);
		bt.insert(nod);
		
		bt.inOrder(bt.root);
		
		
	}

}
