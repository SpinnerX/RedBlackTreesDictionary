package RedBlackTrees;

public class RedBlackTrees {
    private Node root;
	private String results = "";
    private int _size=10;

	

	// place a new node in the RB tree with data the parameter and color it red. 
	public void add(String data){ //this < that  <0.  this > that  >0
		// Initialize new Node containing data (default is red).
		Node addedNode = new Node(data);
		
		// If root is null, set root to be data.
		if(root == null) root = addedNode;
		else {
			// Initialize currentNode and prevNode variables.
			Node currentNode = root;
			Node prevNode = null;
			
			// Continue to loop until currentNode is a leaf.
			while(currentNode != null) {
				// Sets prevNode to currentNode.
				prevNode = currentNode;
				
				// If value of addedNode is less than currentNode, 
				// move to left side of tree.
				if(addedNode.compareTo(currentNode) < 0) {
					// Set currentNode to left child of currentNode.
					currentNode = currentNode.left;
					// If currentNode is a leaf, set left child of prevNode to addedNode.
					if(currentNode == null) {
						prevNode.left = addedNode;
						prevNode.left.parent = prevNode;
                        _size++;
					}
				}
				// If value of addedNode is greater than or equal to currentNode, 
				// move to right side of tree.
				else {
					// Set currentNode to right child of currentNode.
					currentNode = currentNode.right;
					// If currentNode is a leaf, set right child of prevNode to addedNode.
					if(currentNode == null) {
						prevNode.right = addedNode;
						prevNode.right.parent = prevNode;
                        _size++;
					}
				}
			}
		}
		// Makes sure red black tree properties are still maintained after adding addedNode.
		rebalance(addedNode);
	}

	// Searches for a key and returns true with same key; else returns false.
    public boolean contains(String k){
        if(root == null) return false;

		Node current = root;
		while(current != null){
			if(current.key.equals(k)) return true;
			if(current.key.compareTo(k) > 0) current = current.left;
			else current = current.right;
		}

		return false;
    }

	// Searches for a key and returns node with same key; else returns null.
	public Node containsNode(String k){
		if(root == null) return null;

		Node current = root;
		while(current != null){
			if(current.key.equals(k)) return current;
			if(current.key.compareTo(k) > 0) current = current.left;
			else current = current.right;
		}

		return null;
	}

    // Returns the sibling of Node<Key> n; if not found return null.
    public Node siblings(Node n){
        // Initialize parent variable to be parent of Node n.
        Node parent = n.parent;

        // If Node n does not have a parent, return null.
        if(parent == null) {
            return null;
        } else {
            // If Node n is a left child of parent, return rightChild of parent.
            if(isLeftChild(parent, n)) {
                return parent.right;
            } 
            // Else, return leftChild of parent.
            else {
                return parent.left;
            }
        }
    }

    // Returns the aunt of Node<Key> n; if not found return null.
    public Node aunt(Node n){
        // Initialize parent variable to be parent of Node n.
        Node parent = n.parent;

        // If parent of n is null, return null.
        if(parent == null) return null;
        // Else, use getSibling method to get sibling of parent of Node n.
        else return siblings(parent);
    }

	// Returns grandparent of Node n.
	public Node grandparent(Node n){
		return n.parent.parent;
	}

	// Rotates red black tree left.
	public void rotateLeft(Node x){
		// y is initialized to be the right child of x.
		Node y = x.right;
		
		// x's right child becomes y's left child.
        x.right = y.left;
		
		// If y has a left child, then the parent of y's left child becomes x.
		if(y.left != null) y.left.parent = x;
		
		// Link x's parent to y's parent.
		y.parent = x.parent;
		
		// If x was the root, change it so y is the new root.
		if(x.parent == null) root = y;
		
        // If x is the left child of its parent, set left child of x's parent to y.
		else if(x.compareTo(x.parent.left) == 0) x.parent.left = y;
		
        // Else, set right child of x's parent to y.
		else x.parent.right = y;

		// Set left child of y to x.
		y.left = x;
		// Set parent of x to y.
		x.parent = y;
	}   

	// Rotates red black tree right.
	public void rotateRight(Node y){

		// x is initialized to be y's left child.
		// assign x to the left side of y's childs.
		Node x = y.left;
		
		y.left = x.right; // Left child of y is now right child of x.
		
		if(x.right != null) x.right.parent = y; // x has a right child, set its' parent to y.

		
		x.parent = y.parent; // assign y's parent to x's parent.
		
		if(y.parent == null) root = x; // y is the root, change it so x is the new root.
		else if(y.compareTo(y.parent.right) == 0) y.parent.right = x; // y is the right child, set right child of y's parent to x.
		else y.parent.left = x; // set left child of y's parent to x.
		
		x.right = y; // Set right child of x to y.
		y.parent = x; // Set parent of y to x.
	}

	// Recursively traverses tree to make it a red black tree.
	public void rebalance(Node current) {
		// If current is root, make it black and quit.
		if(current == root) {
			current.isRed = false;
			current.color = 1;
			return;
		} 
		
		// If parent of current is black, quit.
		if(!current.parent.isRed) return;
		
		// If current is red and parent of current is red, fixing is needed.
		if(current.isRed && current.parent.isRed) {
			// If aunt of current is empty or black:
			if(aunt(current) == null || !aunt(current).isRed) {
				// If current is the right child of its parent and its parent is the left child of the grandparent:
				if(!isLeftChild(current.parent, current) && isLeftChild(grandparent(current), current.parent)) {
					// Rotate the parent left.
					rotateLeft(current.parent);
					// Recursively fix tree starting with parent of current.
					rebalance(current.parent);
				} 
				// If current is the left child of its parent and its parent is the right child of the grandparent:
				else if(isLeftChild(current.parent, current) && !isLeftChild(grandparent(current), current.parent)) {
					// Rotate the parent right.
					rotateRight(current.parent);
					// Recursively fix tree starting with parent of current.
					rebalance(current.parent);
				} 
				// If current is the left child of its parent and its parent is the left child of the grandparent:
				else if(isLeftChild(current.parent, current) && isLeftChild(grandparent(current), current.parent)) {
					// Make parent of current black.
					current.parent.isRed = false;
					current.parent.color = 1;
					// Make grandparent of current red.
					grandparent(current).isRed = true;
					grandparent(current).color = 0;
					// Rotate the grandparent to the right and quit.
					rotateRight(grandparent(current));
					return;
				} 
				// If current is the right child of its parent and its parent is the right child of the grandparent:
				else if(!isLeftChild(current.parent, current) && !isLeftChild(grandparent(current), current.parent)) {
					// Make parent of current black.
					current.parent.isRed = false;
					current.parent.color = 1;
					// Make grandparent of current red.
					grandparent(current).isRed = true;
					grandparent(current).color = 0;
					// Rotate the grandparent to the left and quit.
					rotateLeft(grandparent(current));
					return;
				}
			} 
			// If aunt of current is red:
			else if(aunt(current).isRed){
				// Make the parent of current black.
				current.parent.isRed = false;
				current.parent.color = 1;
				// Make the aunt of current black.
				aunt(current).isRed = false;
				aunt(current).color = 1;
				// Make the grandparent of current red.
				grandparent(current).isRed = true;
				grandparent(current).color = 0;
				// Recursively fix the tree starting with grandparent of current.
				rebalance(grandparent(current));
			}
		}
	}

	public String getString(){ return results; }

    public int size(){ return _size; }

	public boolean isEmpty(Node n){ return (n.key == null); }

	public boolean isLeftChild(Node parent, Node child){ return child.compareTo(parent) < 0; }

    // Prints tree in preorder format starting with the root.
	//preorder: visit, go left, go right
	public void print(){ recursive_print(root); }

	// Prints tree in preorder format.
	public void recursive_print(Node temp){
		if(temp == null) return;

        recursive_print(temp.left);
        System.out.print(temp.key + " ");
        recursive_print(temp.right);
	}


	public void preOrderVisit(String label) {
		preOrderVisit(root, label);
	}
	
	private void preOrderVisit(Node n, String label) {
		if (n == null) return;
		if(label == "Visit 1") visits(n);
		else visit(n);

		preOrderVisit(n.left, label);
		preOrderVisit(n.right, label);
	}
	
	// Adds only the data to the results string.
	private void visit(Node n){ results += n.key; }

	// Print add information to the results string.
	private void visits(Node n){
		if(!(n.key).equals("") && n.parent == null) results = results +"Color: "+n.color+", Key:"+n.key+" Parent: \n";
    	else if(!(n.key).equals("")) results = results +"Color: "+n.color+", Key:"+n.key+" Parent: "+n.parent.key+"\n";
	}
}