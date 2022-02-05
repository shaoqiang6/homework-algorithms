package reverseNodesInKGroup0025;

import org.junit.Test;
import utils.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 3：
 *
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 提示：
 *
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shaoqiangyan
 */
public class Solution {


    public ListNode reverseKGroup(ListNode head, int k) {
//        return reverse1(head, k);
        return reverse2(head, k);
    }

    private ListNode reverse2(ListNode head, int k) {
        ListNode protect = new ListNode(-1, head);
        ListNode last = protect;
        while (head != null) {

            ListNode end = getEnd(head, k);
            if (null == end) {
                break;
            }
            ListNode nextGroupHead = end.next;

            reverseBegin2End(head, nextGroupHead);
            // 3. 更新每一组与前一组 后一组的边
            last.next = end;
            head.next = nextGroupHead;

            last = head;
            head = nextGroupHead;

        }

        return protect.next;
    }

    private ListNode reverseBegin2End(ListNode head, ListNode end) {
        ListNode last = head;
        head = head.next;
        while (head != end) {
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
        return last;
    }

    private ListNode getEnd(ListNode head, int k) {
        while(head != null) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    private ListNode reverse1(ListNode head, int k) {
        // 增加一个保护节点, 最后返回hair.next就可以了
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode pre = hair;
        while(head != null) {
            ListNode tail = pre;
            // 判断剩余节点数是否够k个, 如果不够就返回
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            // tail 到现在就是当前组的最后一个, 也是下一组的pre, nex 是下一组的开始
            ListNode nex = tail.next;
            // 反转
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            tail.next = nex;
            pre.next = head;
            pre = tail;
            head = pre.next;
        }

        return hair.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        System.out.println("reverse, head:" + head + " | tail:" + tail);
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        System.out.println("reverse, head:" + head + " | tail:" + tail);
        return new ListNode[]{tail, head};
    }
    @Test
    public void test() {
        ListNode listNode = ListNode.mockSortedNode(1, 5);
        System.out.println(listNode);
        ListNode listNode1 = reverseKGroup(listNode, 2);
        System.out.println(listNode1);

    }
}
