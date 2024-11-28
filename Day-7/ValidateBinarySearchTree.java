import java.util.Scanner;
class ValidateBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public boolean isValidBST(TreeNode root) {
        return isvalidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isvalidBst(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;
        return isvalidBst(root.left, minVal, root.val) && isvalidBst(root.right, root.val, maxVal);
    }
    private static TreeNode createTree(Scanner scanner) {
        System.out.println("Enter node value (-1 for null):");
        int val = scanner.nextInt();
        if (val == -1) return null;
        TreeNode node = new TreeNode(val);
        System.out.println("Enter left child of " + val);
        node.left = createTree(scanner);
        System.out.println("Enter right child of " + val);
        node.right = createTree(scanner);
        return node;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Build your binary tree:");
        TreeNode root = createTree(scanner);
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        boolean isValid = solution.isValidBST(root);
        System.out.println("Is the binary tree a valid BST? " + isValid);
        scanner.close();
    }
}
