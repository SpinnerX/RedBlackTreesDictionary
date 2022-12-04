package RedBlackTrees;

public class Node {
    public Node(String data){
        this.data  = data;
    }

    public Node(String data, boolean isRed, String label){
        this.data = data;
        this.isRed = isRed;
        this.label = label;
    }

    Node left=null;
    Node right=null;
    String data=""; // contains words.
    boolean isRed = false; // true = red, false = black
    String label = ""; // labels node as RED or BLACK

    public boolean red() { return isRed; }
}
