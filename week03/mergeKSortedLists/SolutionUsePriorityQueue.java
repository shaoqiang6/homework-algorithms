package mergeKSortedLists;

import utils.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

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
public class SolutionUsePriorityQueue {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<NodeSort> queue = new PriorityQueue<>();
        for(ListNode node : lists) {
            if (null != node) {
                queue.offer(new NodeSort(node));
            }
        }
        ListNode head = new ListNode(-1);
        // 初始化尾部指向头部
        ListNode tail = head;
        while (!queue.isEmpty()) {
            // poll出最小val的节点
            NodeSort poll = queue.poll();
            // 更新尾部节点
            tail.next = poll.node;
            // 移动尾部节点
            tail = tail.next;
            // 如果优先级队列中的这个节点还有next,则将next放到队列中去排队
            if (null != poll.node.next) {
                // 每次offer时间复杂度?
                queue.offer(new NodeSort(poll.node.next));
            }
        }
        return head.next;

    }

    @Test
    public void test() {
        ListNode listNode1 = ListNode.mockSortedNode(2, 1);
        System.out.println(listNode1);
        ListNode listNode2 = ListNode.mockSortedNode(1, 2);
        System.out.println(listNode2);
        ListNode listNode = mergeKLists(Arrays.asList(listNode1, listNode2).toArray(new ListNode[]{}));
        System.out.println(listNode);

    }


    /**
     * 用来将多个子链表排序, 排序规则就是val正序
     */
    private static class NodeSort implements Comparable<NodeSort> {
        /**
         * 头结点的val
         */
        int val;
        /**
         * 子链表
         */
        ListNode node;
        public NodeSort(ListNode node) {
            val= node.val;
            this.node = node;
        }

        @Override
        public int compareTo(NodeSort status2) {
            return this.val - status2.val;
        }
    }


}
