import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BalanceTreeCheck {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String[] ip = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < ip.length) {
            Node currNode = queue.poll();
            String currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t > 0) {
            String s = scanner.nextLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            if (g.isBalanced(root))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
        scanner.close();
    }
}

class Tree {
    boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = checkHeight(node.left);
        if (lh == -1) {
            return -1;
        }
        int rh = checkHeight(node.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }
}
