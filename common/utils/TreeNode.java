package utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "{" +
                "\"val\":" + val +
                (left == null ? "" : ", \"left\":" +  left) +
                (right == null ? "" : ", \"right\":" + right) +
                '}';
    }

    public static TreeNode mock(int level) {
        if (level < 1) {
            return new TreeNode(0);
        }
        int val = 1;
        TreeNode root = new TreeNode(++val);
        root.left = new TreeNode(++val, mock(level - 1), mock(level - 1));
        root.right = new TreeNode(++val);
        return root;
    }


    public static TreeNode mockBinarySearchTree(int rootVal) {
        TreeNode root = new TreeNode(rootVal);
        root.left = new TreeNode(rootVal - 2);
        root.left.left = new TreeNode(rootVal - 3);
        root.left.right = new TreeNode(rootVal - 1);

        root.right = new TreeNode(rootVal + 2);
        root.right.left = new TreeNode(rootVal + 1);
        root.right.right = new TreeNode(rootVal + 3);
        return root;
    }
}
