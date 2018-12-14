import java.util.ArrayList;
 
public class BST{
 
    private class BSTNode {
        int value;
        BSTNode left;
        BSTNode right;
 
        public BSTNode(int value){
            this.value = value;
        }
 
        // Adapted from Todd Davies answer to printing a BST on Stack Overflow.
        // https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
        private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if(right!=null) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value).append("\n");
            if(left!=null) {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }
            return sb;
        }
 
        @Override
        public String toString() {
            return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }
 
    private BSTNode root;
 
    private BSTNode insert(BSTNode curr, int value){
        if (curr == null)
            return new BSTNode(value);
        if (value > curr.value)
            curr.right = insert(curr.right, value);
        else if (value < curr.value)
            curr.left = insert(curr.left, value); 
        return curr;
    }
 
    public void insert(int value){
        root = insert(root, value);
    }
 
    private boolean search(BSTNode curr, int value){
        System.out.println("Visiting: " + (curr == null ? "null :(" : curr.value));
        if (curr == null) return false;
        if (curr.value == value) return true;
        if (value > curr.value)
            return search(curr.right, value);
        return search(curr.left, value);
    }
 
    public boolean search(int value){
        return search(root, value);
    }
 
    private BSTNode remove(BSTNode curr, int value) {
        if(curr == null) return curr;
	if (value < curr.value)
            curr.left = remove(curr.left, value);
        else if (value > curr.value)
            curr.right = remove(curr.right, value);
        else {
	    if(curr.left == null && curr.right == null)
		curr = null;
	    else if(curr.left != null && curr.right == null)
		curr = curr.left;
	    else if(curr.left == null && curr.right != null)
		curr = curr.right;
	    else if(curr.left != null && curr.right != null){
		int temp = max(curr.left);
		remove(temp);
		curr.value = temp;
	    }
	} 
	return curr;
    }

    private int max(BSTNode curr){
	    if(curr.right != null){
		max(curr.right);
	  }  
	return curr.value;
    }
    

    public void remove(int value){
	remove(root, value);
    }

private void printInOrder(BSTNode curr){
    if (curr != null) {
	// Print everything in left subtree
	printInOrder(curr.left);
	// Print curr.value
	System.out.print(curr.value + " ");
	// Print everything in right subtree
	printInOrder(curr.right);
    }
}
 
public void printInOrder(){
    printInOrder(root);
    System.out.println();
}
 
public void printTree(){
    System.out.println(root.toString());
}
 
}
