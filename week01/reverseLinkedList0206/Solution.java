package reverseLinkedList0206;

import org.junit.Test;
import utils.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @author shaoqiangyan
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // 当前节点
        ListNode curr = head;
        // 上一个节点
        ListNode last = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }
        return last;
    }


    @Test
    public void test() {
        ListNode listNode = ListNode.mockSortedNode(1, 5);
        System.out.println(listNode);
        ListNode listNode1 = reverseList(listNode);
        System.out.println(listNode);
        System.out.println(listNode1);


    }
}
