import java.util.*;

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class RightViewBinaryTree {
    public static void printRightView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
                if (i == n) {
                    System.out.print(temp.data + " ");
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }
    public static Node buildTree() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the root node data: ");
        int rootData = sc.nextInt();
        if (rootData == -1) return null; 
        Node root = new Node(rootData);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Enter left child of " + current.data + " (enter -1 if no left child): ");
            int leftData = sc.nextInt();
            if (leftData != -1) {
                current.left = new Node(leftData);
                queue.add(current.left);
            }

            System.out.print("Enter right child of " + current.data + " (enter -1 if no right child): ");
            int rightData = sc.nextInt();
            if (rightData != -1) {
                current.right = new Node(rightData);
                queue.add(current.right);
            }
        }
        
        sc.close();
        return root;
    }

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println("Right view of the binary tree is:");
        printRightView(root);
    }
}
