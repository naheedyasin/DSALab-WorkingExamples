package lab10;
//lab10

class Node1 {
    int key, height;
    Node1 left, right;

    Node1(int d) {
        key = d;
        height = 1;
    }
}

public class AVLTree {

    Node1 root;

    int height(Node1 n) {
        if(n == null){
            return 0;
        }
        return n.height;
    }

    int max(int a,int b){
        return (a>b)? a: b;
    }


    Node1 rightRotate(Node1 y) {
        Node1 x = y.left;
        Node1 T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node1 leftRotate(Node1 x) {
        Node1 y = x.right;
        Node1 T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node1 n) {
        if(n == null){
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    Node1 insert(Node1 node, int key) {
        if (node == null) {
            return (new Node1(key));
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    Node1 minValueNode(Node1 node) {
        Node1 current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    //Labtask.
    Node1 delete(Node1 root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                Node1 temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node1 temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }

        if (root == null) {
            return root;
        }

        root.height = 1 + max(height(root.left), height(root.right));

        int balance = getBalance(root);

        //LL Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        //LR Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RR Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        //RL Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    void printInorder(Node1 node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);

    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("\nInorder traversal of constructed tree is: ");
        tree.printInorder(tree.root);

        System.out.println("\n\nDeleting node 25.");
        tree.root = tree.delete(tree.root, 25);

        System.out.println("\nInorder traversal after deletion is: ");
        tree.printInorder(tree.root);

    }
}