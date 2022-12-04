package RedBlackTrees;

import javax.xml.crypto.Data;

public class RedBlackTrees {
    public Node root = null;
    public int size = 1;

    public RedBlackTrees(){}

    public void add(String data){
        if(isEmpty()){
            root = new Node(data);
            return;
        }

        Node current = root;

        while(true){
            if(current.data.equals(data)) return;

            if(current.data.compareTo(data) != 0){
                if(current.left == null){
                    current.left = new Node(data);
                    size++;
                    return;
                }
                current = current.left;
            }
            else{
                if(current.right == null){
                    current.right = new Node(data);
                    size++;
                    return;
                }
                current = current.right;
            }
        }
    }

    public void remove(String data){
        if(isEmpty()) return;

        Node current = root;
        Node prev = null;

        while(current != null && !current.data.equals(data)){
            prev = current;
            if(data.length() < current.data.length()) current = current.left;
            else current = current.right;
        }

        if(current.left == null || current.right == null){
            Node newNode;

            if(current.left == null) newNode = current.right;
            else newNode = current.left;

            if(prev == null) return;

            if(current == prev.left) prev.left = newNode;
            else prev.right = newNode;
            size--;
        }
        else{
            Node p = null;
            Node temp = current.right;

            while(temp.left != null){
                p = temp;
                temp = temp.left;
            }


            if(p != null) p.left = temp.right;
            else current.right = temp.right;

            current.data = temp.data;
            size--;
        }

    }

    public boolean contains(String data){
        if(isEmpty()) return false;

        Node current = root;

        while(current != null){
            if(current.data.equals(data)) return true;
            if(data.length() < current.data.length()) current = current.left;
            else current = current.right;
        }

        return false;
    }

    // rebalances RBT
    public void reblance(){}

    // recoloring the entire R-B-T
    public void recoloring(){}


    public void updateColor() { }
    public void updateColorLabel(){}


    public void print(){ recursive_print(root); }

    public boolean isEmpty() { return root == null; }

    public int size(){ return size; }

    private void recursive_print(Node temp){
        if(temp == null) return;

        recursive_print(temp.left);
        System.out.println(temp.data);
        recursive_print(temp.right);
    }
}
