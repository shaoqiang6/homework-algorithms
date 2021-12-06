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
    public ListNode(int val, ListNode nextNode) {
        this.val = val;
        this.next = nextNode;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}
