import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class HeightBinaryTree {
    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static Node createTree(Scanner sc) {
        System.out.print("Enter node value (-1 for no node): ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node node = new Node(data);
        System.out.println("Enter left child of " + data);
        node.left = createTree(sc);
        System.out.println("Enter right child of " + data);
        node.right = createTree(sc); 
        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create your binary tree:");
        Node root = createTree(sc); 
        System.out.println("Maximum depth of the tree: " + maxDepth(root));
        sc.close();
    }
}
