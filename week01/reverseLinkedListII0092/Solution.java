package reverseLinkedListII0092;

import org.junit.Test;
import utils.ListNode;

/**
 * 92. 反转链表 II
 *给你单链表的头指针 head 和两个整数 left 和 right ，其中: left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author shaoqiangyan
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (null == head) {
            return null;
        }
        ListNode protect = new ListNode(-1, head);
        // 找到需要反转的节点的上一个节点
        ListNode lastNode = protect;
        for(int i = 0; i < left - 1; i++) {
            if(lastNode != null) {
                lastNode = lastNode.next;
            }
        }

        if (null == lastNode) {
            return null;
        }
        ListNode leftNode = lastNode.next;
        ListNode rightNode = lastNode;
        for(int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode next = rightNode.next;
        reverseBegin2End(leftNode, next);

        lastNode.next = rightNode;

        leftNode.next = next;
        return protect.next;
    }

    private void reverseBegin2End(ListNode head, ListNode next) {
        ListNode last = head;
        head = head.next;
        while(head != next) {
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
        head = last;
    }

    @Test
    public void test() {
        ListNode listNode = ListNode.mockSortedNode(1, 5);
        System.out.println(listNode);
        System.out.println(reverseBetween(listNode, 2, 4));
        listNode = ListNode.mockSortedNode(1, 1);
        System.out.println(listNode);
        System.out.println(reverseBetween(listNode, 1, 1));

    }
}
