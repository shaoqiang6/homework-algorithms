package mergeTwoSortedLists;

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
    public ListNode(int val, ListNode node) {
        this.val = val;
        this.next = node;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
