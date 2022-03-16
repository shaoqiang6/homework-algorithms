package binaryTreeInorderTraversal;

import org.junit.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author shaoqiangyan
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
//        dfs(root, ans);
        useStack(root, ans);
        return ans;

    }
    private void useStack(TreeNode root, List<Integer> list) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    @Test
    public void test() {
        TreeNode mock = TreeNode.mock();
        List<Integer> list = inorderTraversal(mock);
        System.out.println(list);

    }
}
