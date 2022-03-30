import java.lang.IllegalStateException;
import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<T extends Comparable<T>> {
    
    private final boolean BLACK = false;
    private final boolean RED = true;
    private Node root;

    public RedBlackTree() {
        this.root = null;
    }

    protected Node getRoot() {
        return this.root;
    }

    protected void inOrderTraverseTree(Node node) {
        if (node == null) { return; } // Node does not exist
        inOrderTraverseTree(node.getLeft()); // In-order traverse the left subtree
        System.out.print("[" + node.getData() + " : " + node.getColor() + "], "); // Print the current node
        inOrderTraverseTree(node.getRight()); // In-order traverse the right subtree
    }

    protected void levelOrderTraverseTree(Node node) {
        Queue<Node> queue = new LinkedList<Node>(); // Use queue to hold nodes
        queue.add(root); // Enqueue the root
        while (!queue.isEmpty()) { // Until there are no nodes left
            Node temp = queue.poll(); // Dequeue current node
            System.out.print("[" + temp.getData() + " : " + temp.getColor() + "], "); // Print the current node
            if (temp.getLeft() != null) { queue.add(temp.getLeft()); } // Enqueue left child
            if (temp.getRight() != null) { queue.add(temp.getRight()); } // Enqueue right child
        }
    }

    protected void insert(T data) {
        Node node = this.root; // Start at root node
        Node parent = null; // Parent of root is null
        Node newNode = new Node(data); // New node
        while (node != null) { // Traverse tree
            parent = node; // Parent is the current node
            if (newNode.compareTo(node) <= 0) { node = node.getLeft(); } // Traverse left
            else { node = node.getRight(); } // Traverse right
        }
        newNode.setColor(RED); // Set new node's color to red
        if (parent == null) { this.root = newNode; } // New node is root node
        else if (newNode.compareTo(parent) <= 0) { parent.setLeft(newNode); } // New node is node's let child
        else { parent.setRight(newNode); } // New node is node's right child
        newNode.setParent(parent); // Set new node's parent to parent
        checkInsertProperties(newNode); // Check tree properties
    }

    protected void delete(T data) {
        Node node = root; // Start search at root node
        Node temp = new Node(data); // Temp node
        while (node != null && temp.compareTo(node) != 0) {
            if (temp.compareTo(node) < 0) { node = node.getLeft();}
            else { node = node.getRight(); }
        }
        if (node == null) { return; } // Node with that data value is not in the tree 
        boolean replacementNodeColor; // Color of  deleted node
        Node replacementNode; // Color of 
        if (node.getLeft() != null && node.getRight() != null) { // Delete node has two children
            Node successor = minNode(node.getRight()); // Successor is min node of right subtree
            node.setData(successor.getData()); // Successor is replacing deleted node so take its data
            replacementNodeColor = successor.getColor(); // Color of successor
            replacementNode = deleteNode(successor); // Deletes the successor node
        }
        else { // Delete node has one or zero children
            replacementNode = deleteNode(node);
            replacementNodeColor = node.getColor();
        }
        if (replacementNodeColor == BLACK) { 
            checkDeleteProperties(replacementNode); // Check replacement node's tree properties
            if (replacementNode.getClass() == NilNode.class) { // Replacement node is a nil node
                replaceParentsChild(replacementNode.getParent(), replacementNode, null); //Fix node relationships
            }
        }
    }

    protected Node deleteNode(Node node) {
        if (node.getLeft() != null) { // Node has left child
            replaceParentsChild(node.getParent(), node, node.getLeft());
            return node.getLeft(); // Return node's left child
        }
        else if (node.getRight() != null) { // Node has right child
            replaceParentsChild(node.getParent(), node, node.getRight());
            return node.getRight(); // Return node's right child
        }
        // If node's color is black replace it with a nil node, otherwise replace it with null
        Node newChild = node.getColor() == BLACK ? new NilNode() : null;
        replaceParentsChild(node.getParent(), node, newChild); // Fix node relationships
        return newChild; // New node
    }

    private Node minNode(Node node) {
        while (node.getLeft() != null) { // Traverse left subtree
            node = node.getLeft(); // Set node to left child
        }
        return node; // Return node
    }

    private void checkDeleteProperties(Node node) {
        if (node == this.root) { node.setColor(BLACK); return;} // Node is root node
        Node sibling = getSibling(node); // Sibling node
        if (sibling.getColor() == RED) { // Sibling is red
            redSibling(node, sibling);
            sibling = getSibling(node); // Sibling node is new sibling of node
        } // Sibling is black with two  black children
        if (sibling.getLeft().getColor() == BLACK && sibling.getRight().getColor() ==  BLACK) {
            sibling.setColor(RED); // Recolor sibling to red
            if (node.getParent().getColor() == RED) { // Parent node is red
                node.getParent().setColor(BLACK); // Recolor parent to black
            }
            else { // Parent is black
                checkDeleteProperties(node.getParent()); // Check parent tree's properties
            }
        }
        else {
           blackSibling(node, sibling); // Black sibling with red children
        }
    }

    private void blackSibling(Node node, Node sibling) {
        boolean nodeIsLeft = node == node.getParent().getLeft(); // Node is the left child or not
        if (nodeIsLeft && sibling.getRight().getColor() == BLACK) { // Node is left and sibling's right is black
            sibling.getLeft().setColor(BLACK); // Recolor sibling's left to black
            sibling.setColor(RED); // Recolor sibling to red
            rightRotation(sibling); // Perform right rotation on sibling
            sibling = node.getParent().getRight(); // Sibling is now parent's right child
        }
        else if (nodeIsLeft && sibling.getLeft().getColor() == BLACK) { // Node is left and sibling's left is black
            sibling.getRight().setColor(BLACK); // Recolor sibling's right to black
            sibling.setColor(RED); // Recolor sibling to red
            leftRotation(sibling); // Perform left rotation on sibling
            sibling = node.getParent().getLeft(); // Sibling is now parent's left child
        }
        sibling.setColor(node.getParent().getColor()); // Recolor sibling to parent's color
        node.getParent().setColor(BLACK); // Recolor parent to black
        if (nodeIsLeft) { // Node is left child and sibling has no black children
            sibling.getRight().setColor(BLACK); // Recolor sibling's right child to black
            leftRotation(node.getParent()); // Perform left rotation on node's parent
        }
        else { // Node is right child
            sibling.getLeft().setColor(BLACK); // Recolor sibling's left child to black
            rightRotation(node.getParent()); // Perform right rotation on node's parent
        }
    }

    private void redSibling(Node node, Node  sibling) {
        Node parent = node.getParent(); // Parent node
        sibling.setColor(BLACK); // Recolor sibling to black
        parent.setColor(RED); // Recolor parent to red
        if (node == parent.getLeft()) { leftRotation(parent);} // Perform left rotation
        else { rightRotation(parent); } // Perform right rotation
    }
    
    private void checkInsertProperties(Node node) {
        Node parent = node.getParent(); // Parent node
        if (parent == null) { node.setColor(BLACK); return; } // Root node
        if (parent.getColor() == BLACK) { return; } // Black parent is fine
        Node grandparent = parent.getParent(); // Grandparent node
        if (grandparent == null) { parent.setColor(BLACK); return;} // Parent is root
        Node uncle = getUncle(parent); // Uncle node
        // Parent is red so we must check grandparent and uncle
        if (uncle != null && uncle.getColor() == RED) { // Uncle is red
            parent.setColor(BLACK); // Recolor parent to black
            grandparent.setColor(RED); // Recolor grandparent to red
            uncle.setColor(BLACK); // Recolor uncle to black
            checkInsertProperties(grandparent); // Check grandparent's parent tree properties
        }
        else if (parent == grandparent.getLeft()) { // Uncle is black and parent is grandparent's left child
            if (node == parent.getRight())  { // Current node is parent's right child
                leftRotation(parent); // Perform left rotation of parent node
                parent = node; // Parent is now current node
            }
            rightRotation(grandparent); // Perform right rotation of grandparent node
            parent.setColor(BLACK); // Recolor parent to black
            grandparent.setColor(RED); // Recolor grandparent to red
        }
        else { // Uncle is black parent is grandparent's right child
            if (node == parent.getLeft()) { // Current node is parent's left child
                rightRotation(parent); // Perform right rotation of parent node
                parent = node; // Parent is now current node
            }
            leftRotation(grandparent); // Perform left rotation of grandparent node
            parent.setColor(BLACK); // Recolor parent to black
            grandparent.setColor(RED); // Recolor grandparent to red
        }

    }

    private Node getUncle(Node node) {
        Node grandparent = node.getParent(); // Grandparent node
        if (grandparent.getLeft() == node) { return grandparent.getRight(); } // Uncle is right
        if (grandparent.getRight() == node) { return grandparent.getLeft(); } // Uncle is left
        throw new IllegalStateException("Parent is not the child of grandparent"); // Parent/Grandparent relationship error
    }

    private Node getSibling(Node node) {
        Node parent = node.getParent(); // Parent node
        if (parent.getLeft() == node) { return parent.getRight(); } // Sibling is right
        if (parent.getRight() == node) { return parent.getLeft(); } // Sibling is left
        throw new IllegalStateException("Node is not the child of parent"); // Node/Parent relationship error
    }

    private void rightRotation(Node node) {
        Node parent = node.getParent(); // Parent node
        Node left = node.getLeft(); // Left child node
        node.setLeft(left.getRight()); // Set left child to left's right child
        if (left.getRight() != null) { // If left's right child exists
            left.getRight().setParent(node); // Set left's new parent to current node
        }
        left.setRight(node); // Left's right is the current node
        node.setParent(left); // Current node's parent is now left
        replaceParentsChild(parent, node, left); // Fix parent child relationships
    }

    private void leftRotation(Node node) {
        Node parent = node.getParent(); // Parent node
        Node right = node.getRight(); // Right child node
        node.setRight(right.getLeft()); // Set right child to right's left child
        if (right.getLeft() != null) { // If right's left exists
            right.getLeft().setParent(node); // Set right's new parent to current node
        }
        right.setLeft(node); // Right's left is node the current node
        node.setParent(right); // Current node's parent is now right
        replaceParentsChild(parent, node, right); // Fix parent child relationships
    }

    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) { this.root = newChild; } // Parent is null so newChild is the root
        else if (parent.getLeft() == oldChild) { parent.setLeft(newChild); } // Replace parent's left child with newChild
        else if (parent.getRight() == oldChild) { parent.setRight(newChild); } // Replace parent's right child with newChild
        else { throw new IllegalStateException("Node is not a child of its parent"); } // oldChild is a child at all
        if (newChild != null) { newChild.setParent(parent); } // newChild's parent is parent
    }

    private class NilNode extends Node {
        private NilNode() {
            super(null);
            this.setColor(false);
        }
    }
    
    private class Node {
    
       private T data;
       private boolean color;
       private Node parent;
       private Node left;
       private Node right;
   
       public Node(T data) {
           this.data = data;
       }
   
       protected T getData() {
           return this.data;
       }
   
       protected boolean getColor() {
           return this.color;
       }
   
       protected Node getParent() {
           return this.parent;
       }
   
       protected Node getLeft() {
           return this.left;
       }
   
       protected Node getRight() {
           return this.right;
       }
   
       protected void setData(T data) {
           this.data = data;
       }
   
       protected void setColor(boolean color) {
           this.color = color;
       }
   
       protected void setParent(Node node) {
           this.parent = node;
       }
   
       protected void setLeft(Node node) {
           this.left = node;
       }
   
       protected void setRight(Node node) {
           this.right = node;
       }
   
       public int compareTo(Node node) {
           return this.data.compareTo(node.getData());
       }
    }
}
