public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> rbt = new RedBlackTree<>(); ;
        rbt.insert(Integer.valueOf(45)); 
        rbt.insert(Integer.valueOf(67)); 
        rbt.insert(Integer.valueOf(100)); 
        rbt.insert(Integer.valueOf(4)); 
        rbt.insert(Integer.valueOf(93)); 
        rbt.insert(Integer.valueOf(28));
        rbt.insert(Integer.valueOf(46)); 
        rbt.insert(Integer.valueOf(70)); 
        rbt.insert(Integer.valueOf(84)); 
        rbt.insert(Integer.valueOf(-12)); 
        rbt.insert(Integer.valueOf(31)); 
        rbt.insert(Integer.valueOf(292));
        rbt.insert(Integer.valueOf(5)); 
        rbt.insert(Integer.valueOf(667)); 
        
        rbt.inOrderTraverseTree(rbt.getRoot());
        System.out.println();
        System.out.println("Insert 59:");
        rbt.insert(Integer.valueOf(59));
        rbt.inOrderTraverseTree(rbt.getRoot());

        System.out.println();
        rbt.levelOrderTraverseTree(rbt.getRoot());
        System.out.println();
        System.out.println("Delete 70:");
        rbt.delete(Integer.valueOf(70));
        rbt.levelOrderTraverseTree(rbt.getRoot());
        System.out.println();

        System.out.println("In-Order Traversal:");
        rbt.inOrderTraverseTree(rbt.getRoot());
        System.out.println();
        System.out.println("Level-Order Traversal:");
        rbt.levelOrderTraverseTree(rbt.getRoot());

    }
}
