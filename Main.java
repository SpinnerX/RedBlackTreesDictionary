import RedBlackTrees.RedBlackTrees;

public class Main{
	public static void main(String[] args){
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