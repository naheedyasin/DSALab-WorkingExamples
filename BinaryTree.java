package lab8;

class Node{
    int key;
    Node left,right;

    public Node(int item){
        key = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;
    BinaryTree(int key){
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    /*traversing methods.
    preorder = root,left,right
    inorder = left,root,right
    postorder = left,right,root
    */

    void printPreorder(Node node){
        if (node == null) return;

        System.out.print(node.key+" ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printInorder(Node node){
        if(node == null) return;
        printInorder(node.left);
        System.out.print(node.key+" ");
        printInorder(node.right);
    }

    void printPostorder(Node node){
        if(node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    //this calculates the height of the binary tree.
    int calculateLevel(Node node){
        if(node == null) return 0;
        int leftHeight = calculateLevel(node.left);
        int rightHeight = calculateLevel(node.right);
        return Math.max(leftHeight,rightHeight) +1;
    }

    boolean isFullBinaryTree(Node node){
        if(node == null) return true;

        if(node.left == null && node.right == null) return true;

        if(node.left != null && node.right !=null){
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }

        return false;
    }

    boolean checkChildrenSumProperty(Node node){
        if(node == null || (node.left == null && node.right == null)) return true;

        int leftData = (node.left !=null) ? node.left.key :0;
        int rightData = (node.right !=null) ? node.right.key:0;

        if(node.key == leftData+rightData){
            return checkChildrenSumProperty(node.left) && checkChildrenSumProperty(node.right);
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        Node a = new Node(2);
        tree.root.left = a;
        Node b = new Node(3);
        tree.root.right = b;

        a.left = new Node(4);
        a.right = new Node(5);

        System.out.println("Pre-order:");
        tree.printPreorder(tree.root);

        System.out.println("\nPost-Order:");
        tree.printPostorder(tree.root);

        System.out.println("\nIn-Order: ");
        tree.printInorder(tree.root);

        System.out.println("\nLevel of the Tree = "+tree.calculateLevel(tree.root));

        if(tree.isFullBinaryTree(tree.root)){
            System.out.println("The tree is a full binary tree");
        }else{
            System.out.println("The tree is not a full binary tree");
        }

        if(tree.checkChildrenSumProperty(tree.root)){
            System.out.println("satisfies the children sum property");
        }else{
            System.out.println("doesnt satisfy the children sum property");
        }



    }
}
