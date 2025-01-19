package lab9;

//lab 9 task.

public class BinaryExpressionTree {

    /*           /
             /       \
             *        +
           /   \     / \
           +    -    2  9
          / \  / \
         5   2 2  1
*/
    static class Node {
        String value;
        Node left, right;

        Node(String value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public BinaryExpressionTree() {
        root = new Node("/");
        root.left = new Node("*");
        root.right = new Node("+");

        root.left.left = new Node("+");
        root.left.right = new Node("-");

        root.right.left = new Node("2");
        root.right.right = new Node("9");

        root.left.left.left = new Node("5");
        root.left.left.right = new Node("2");

        root.left.right.left = new Node("2");
        root.left.right.right = new Node("1");
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }

    public void inorder() {
        inorderTraversal(root);
    }

    public static void main(String[] args) {
        BinaryExpressionTree tree = new BinaryExpressionTree();

        System.out.println("In-order Traversal of Expression Tree:");
        tree.inorder();
    }
}
