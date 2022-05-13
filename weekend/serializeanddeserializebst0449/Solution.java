package serializeanddeserializebst0449;

import org.junit.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 * @author shaoqiangyan
 */
public class Solution {
    private static String split = ",";

    public String serialize(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        seHelper(nodes, root);
        StringBuilder sb = new StringBuilder();
        for (Integer node : nodes) {
            sb.append(node).append(split);
        }
        return sb.toString();
    }
    private void seHelper(List<Integer> nodes, TreeNode root) {
        if (null == root) {
            return;
        }
        nodes.add(root.val);
        seHelper(nodes, root.left);
        seHelper(nodes, root.right);
    }


    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strings = data.split(Solution.split);
        int[] nodes = new int[strings.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Integer.parseInt(strings[i]);
        }
        return deHelper(nodes, 0, strings.length - 1);
    }

    private TreeNode deHelper(int[] nodes, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[left]);
        int bound = right + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nodes[i] >= nodes[left]) {
                bound = i;
                break;
            }
        }
        root.left = deHelper(nodes, left + 1, bound - 1);
        root.right = deHelper(nodes, bound, right);
        return root;
    }

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.mockBinarySearchTree(10);
        System.out.println(treeNode);
        String serialize = serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);


    }





}
