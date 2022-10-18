
public class tree<Key extends Comparable> {
    private Node root = null;

    public tree() {
    }

    public void add(Key key) {
        if (this.root == null) {
            this.root = new Node(key);
        } else {
            this.root.insert(key);
        }

    }

    public void inorderTraversal() {
        this.inorderHelper(this.root);
    }

    private void inorderHelper(Node node) {
        if (node != null) {
            this.inorderHelper(node.left);
            System.out.printf("%s ", node.data);
            this.inorderHelper(node.right);
        }
    }

    private static class Node<Key extends Comparable<Key>> {
        Key data;
        Node<Key> left;
        Node<Key> right;

        public Node(Key key) {
            this.data = key;
            this.left = this.right = null;
        }

        public void insert(Key key) {
            if (key.compareTo(this.data) < 0) {
                if (this.left == null) {
                    this.left = new Node(key);
                } else {
                    this.left.insert(key);
                }
            } else if (key.compareTo(this.data) > 0) {
                if (this.right == null) {
                    this.right = new Node(key);
                } else {
                    this.right.insert(key);
                }
            }

        }
    }
}
