public class Test12 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(1);
        bst.add(8);
        bst.add(7);
        bst.add(5);

        System.out.print("Inorder traversal: ");
        bst.inorderTraversal();
        System.out.println();

        System.out.print("Preorder traversal: ");
        bst.preorderTraversal();
        System.out.println();

        System.out.print("Postorder traversal: ");
        bst.postorderTraversal();
        System.out.println();

        System.out.println(bst.contains(10));
        System.out.println(bst.contains(8));
        System.out.println(bst.contains(5));
    }
}
