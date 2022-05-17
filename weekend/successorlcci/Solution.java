package successorlcci;

import org.junit.Test;
import utils.TreeNode;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 * 通过次数56,085提交次数89,394
 * @author shaoqiangyan
 */
public class Solution {
    TreeNode ans;
    boolean next = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return ans;
    }

    private void dfs(TreeNode root, TreeNode p) {
        if (null == root) {
            return;
        }
        dfs(root.left, p);
        if (next && null == ans) {
            ans = root;
            return;
        }
        // 找到指定的节点了, 那么答案就是下一次的root
        if (root == p) {
            next = true;
        }
        dfs(root.right, p);
    }

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.mockBinarySearchTree(10);
        System.out.println(treeNode);
        System.out.println(treeNode.right);
        TreeNode treeNode1 = inorderSuccessor(treeNode, treeNode.right);
        System.out.println(treeNode1);
    }


}
