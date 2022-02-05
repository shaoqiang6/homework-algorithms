package utils;

import java.util.Random;

/**
 * @author shaoqiangyan
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
        val = 0;
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode nextNode) {
        this.val = val;
        this.next = nextNode;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }

    /**
     * 升序链表mock
     * @param headVal 头结点的value值
     * @param nodeCount 节点数量
     * @return 升序链表
     */
    public static ListNode mockSortedNode(int headVal, int nodeCount) {
        ListNode head = new ListNode(headVal);
        ListNode end = head;
        Random random = new Random();
        for (int i = 0;i< nodeCount - 1; i++) {
            int incr = i + Math.abs(random.nextInt()) % 3 + 1;
            end.next = new ListNode(end.val + incr);
            end = end.next;
        }
        return head;
    }
}
