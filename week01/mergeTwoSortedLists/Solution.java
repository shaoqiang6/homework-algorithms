package mergeTwoSortedLists;

import org.junit.Test;

import java.util.Random;
/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *         示例 1：
 *
 *
 *         输入：l1 = [1,2,4], l2 = [1,3,4]
 *         输出：[1,1,2,3,4,4]
 *         示例 2：
 *
 *         输入：l1 = [], l2 = []
 *         输出：[]
 *         示例 3：
 *
 *         输入：l1 = [], l2 = [0]
 *         输出：[0]
 *
 *         提示：
 *
 *         两个链表的节点数目范围是 [0, 50]
 *         -100 <= Node.val <= 100
 *         l1 和 l2 均按 非递减顺序 排列
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        // 增加一个保护节点,用来指向合并之后的链表结果
        // 链表val均为为非负整数,这个头结点的val为-1 即最小值
        // 合并之后的新联调的头结点
        ListNode preHead = new ListNode(-1);

        ListNode temp = preHead;
        while(listNode1 != null && listNode2 != null) {
            // 将小的放到temp后面
            // 接下来使用这个链表的next和另一个比较
            if (listNode1.val < listNode2.val) {
                temp.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                temp.next = listNode2;
                listNode2 = listNode2.next;
            }
            // 当前头指针
            temp = temp.next;
        }
        // 合并之后将较长的链表直接放到temp指针的next位置
        temp.next = listNode1 == null ? listNode2 : listNode1;

        return preHead.next;

    }

    @Test
    public void test() {
        ListNode listNode1 = mockNode(2, 1);
        System.out.println(listNode1);
        ListNode listNode2 = mockNode(1, 2);
        System.out.println(listNode2);
        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);

    }

    private ListNode mockNode(int headVal, int nodeCount) {
        ListNode head = new ListNode(headVal);
        ListNode end = head;
        Random random = new Random();
        for (int i = 0;i< nodeCount; i++) {
            int incr = i + Math.abs(random.nextInt()) % 3 + 1;
            end.next = new ListNode(end.val + incr);
            end = end.next;
        }
        return head;
    }
}
