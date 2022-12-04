import java.util.ArrayList;

import RedBlackTrees.RedBlackTrees;

public class Main{
	public static void main(String[] args){
		System.out.println("Testing main java file.");

		Loading l = new Loading();
		ArrayList<String> d = l.LoadDictionary();
		System.out.println(l.contains(d, "aback"));
		ArrayList<String> b = l.LoadPoem();
		System.out.println(l.contains(d, b.get(4)));
		//l.printPoem();

		RedBlackTrees rbt = new RedBlackTrees();

		rbt.add("Taurus");
		rbt.add("Carl");
		rbt.add("Adam");
		rbt.add("Al");

		rbt.print();

		System.out.println(rbt.size());

		rbt.remove("Carl");

		rbt.print();
		System.out.println(rbt.size());
	}

	
}