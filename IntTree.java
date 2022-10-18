public class IntTree {
    private Node root;
    class Node<E>{
        E data;
        Node left, right;
        public Node(E data){
            this(data, null, null);
        }
        public Node(E data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;

        }
    }

    public IntTree(int size){
        root = buildTree(1, size);
        }
    private Node buildTree(int n, int size){
        if (n> size) return null;
        else{
            Node left = buildTree(2*n, size);
            Node right = buildTree(2*n +1, size);
            return new Node(n, left, right);
        }
    }
    public void inorderTraversal(){
        System.out.println("inorder: ");
        inorderHelper(root);
    }
    public void inorderHelper(Node node){
        if(node != null){
            inorderHelper(node.left);
            System.out.print(" " + node.data);
            inorderHelper(node.right);
        }
    }
    public void preorderTraversal(){
        System.out.println("preorder: ");
        preorderHelper(root);
    }
    private void preorderHelper(Node node){
        if(node != null){
            System.out.print(" " + node.data);
            preorderHelper(node.left);
            preorderHelper(node.right);

        }
    }
    public void postorderTraversal(){
        System.out.println("preorder: ");
        postorderHelper(root);
    }
    private void postorderHelper(Node node){
        if(node != null){
            postorderHelper(node.left);
            postorderHelper(node.right);
            System.out.print(" " + node.data);

        }
    }
    public int sum(){
        return sumHelper(root);
    }
    private int sumHelper(Node root){
        if(root == null){
            return 0;
        }
        int left = sumHelper(root.left);
        int right = sumHelper(root.right);
        return (int)root.data + left + right;
    }
    public int countLevels(){
        return countLevelsHelper(root);
    }
    private int countLevelsHelper(Node root){
        if(root == null){
            return 0;
        }
        int left = countLevelsHelper(root.left);
        int right = countLevelsHelper(root.right);
        return 1 + Math.max(left,right);
    }
    public int countLeaves(){
        return countLeavesHelper(root);
    }
    private int countLeavesHelper(Node root){
        if(root.left != null && root.right != null){
            return countLeavesHelper(root.left) + countLeavesHelper(root.right);
        }
        return 1;
    }


    public static void main(String[] args) {
        IntTree intTree = new IntTree(7); // builds a sequential tree of size 7
        intTree.inorderTraversal(); // prints "inorder: 4 2 5 1 6 3 7"
        System.out.println();
        intTree.preorderTraversal();
        System.out.println();
        intTree.postorderTraversal();
        System.out.println();
        System.out.println(intTree.sum());
        System.out.println();
        System.out.println(intTree.countLevels());
        System.out.println();
        System.out.println(intTree.countLeaves());
    }

}


