package mergeKSortedLists;

import utils.ListNode;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * @author shaoqiangyan
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 时间复杂度为 TODO O(nlog n) :  分治相当于是变成二叉树结构的合并子树到,
        // https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
        return mergeKLists(lists, 0, lists.length - 1);
        // 时间复杂度为 O(n*n) 每次merge2Lists为O(n), for循环也是O(n)
//        ListNode temp = lists[0];
//        for(int i = 1; i < lists.length; i++) {
//            temp = merge2Lists(temp, lists[i]);
//        }
//        return temp;
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l +r) / 2;
        ListNode node1 = mergeKLists(lists, l, mid);
        ListNode node2 = mergeKLists(lists, mid +1 , r);
        return merge2Lists(node1, node2);
    }



    public ListNode merge2Lists(ListNode node1, ListNode node2) {
        mergeTwoSortedLists0021.Solution s = new mergeTwoSortedLists0021.Solution();
        return s.mergeTwoLists(node1, node2);

    }




}
