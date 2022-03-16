package utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + (left == null ? "null" : left.val) +
                ", right=" + (right== null ? "null" : right.val) +
                '}';
    }

    public static TreeNode mock() {
        int val = 1;
        TreeNode root = new TreeNode(++val);
        root.left = new TreeNode(++val);
        root.right = new TreeNode(++val);
        return root;
    }
}
