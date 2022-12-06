package RedBlackTrees;

public class Node {
    public String key;  		  
    public Node parent;
    public Node left;
    public Node right;
    public boolean isRed;
    public int color;
    
    public Node(String data){
        this.key = data;
        parent = null;
        left = null;
        right = null;
        isRed = true;
        color = 0; // 0 - RED, 1 - BLACK
    }
    
    //this < that  < 0
    //this > that  > 0
    public int compareTo(Node n) { return key.compareTo(n.key); }
}
