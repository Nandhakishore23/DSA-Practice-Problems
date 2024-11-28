import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

// Custom Pair class to hold a node and its horizontal distance
class Pair {
    TreeNode node;
    int hd;

    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewBinaryTree {
    public static void printTopView(TreeNode root) {
        if (root == null) return;

        // TreeMap to store top view nodes (sorted by horizontal distance)
        Map<Integer, Integer> topViewMap = new TreeMap<>();

        // Queue for level order traversal
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode currentNode = current.node;
            int hd = current.hd;

            // If this horizontal distance is not yet added, add it
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, currentNode.val);
            }

            // Add left and right children with updated horizontal distances
            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, hd - 1));
            }
            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, hd + 1));
            }
        }

        // Print the top view nodes
        for (int value : topViewMap.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        // Example Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Top view of the binary tree:");
        printTopView(root);
    }
}
