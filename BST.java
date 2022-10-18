import java.util.LinkedList;
import java.util.Queue;

public class BST <Key extends Comparable>{
    private Node root;
    private class Node{
        Key key;
        Node left, right;
        public Node(Key key){this(key,null,null);}
        public Node(Key key, Node left, Node right){
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
    public BST(){}
    public void add(Key key) {
        root = add(root,key);}
    private Node add(Node node, Key key){
        if(node == null) return new Node(key);
        int cmp = key.compareTo(node.key);
        if(cmp <= 0) node.left = add(node.left, key);
        else node.right = add(node.right,key);
        return node;
    }
    public void inorderTraversal(){
        inorderHelper(root);
    }
    private void inorderHelper(Node node){
        if(node == null) return;
        inorderHelper(node.left);
        System.out.printf("%s ", node.key);
        inorderHelper(node.right);
    }
    public void preorderTraversal(){
        preorderHelper(root);
    }
    private void preorderHelper(Node node){
        if(node == null) return;
        System.out.printf("%s ", node.key);
        preorderHelper(node.left);
        preorderHelper(node.right);
    }
    public void postorderTraversal(){
        postorderHelper(root);
    }
    private void postorderHelper(Node node){
        if(node == null) return;
        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.printf("%s ", node.key);
    }
    public Key contains(Key key) {
        return containsHelper(root, key);
    }
    private Key containsHelper(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node.key;
        if (cmp < 0)
            return containsHelper(node.left, key);
        else
            return containsHelper(node.right, key);
    }
    void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.key + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }


   /* public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Integer[] keys = {21, 68, 11, 13, 17, 97};
        for (Integer key : keys)
            bst.add(key); // adds key to BST
        bst.inorderTraversal(); // prints sorted keys: 11 13 17 21 68 97
        System.out.println();
        bst.preorderTraversal();
        System.out.println();
        bst.postorderTraversal();
    }*/

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        Integer[] keys = {49, 28, 83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99};
        Integer[] keys2 = {11, 71, 83, 18, 40, 28, 97, 49, 19, 32, 44, 72, 69, 92, 19};
        System.out.println("Inserting the following keys: ");
        for (Integer key : keys) {
            System.out.printf("%d ", key);
            tree.add(key);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
        System.out.printf("%n%nLevelOrder traversal%n");
        tree.levelOrder();



    }
}

//exercise 11.10
//1. out put given in test
//2. the traversal outputs change when you rearrange the elements in the binary tree because the tree's
//   root is the first elements in the input, and the tree is built based on the root's value.