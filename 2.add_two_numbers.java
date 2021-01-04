/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // init new ListNode
        ListNode dummyRoot = new ListNode(0);
        ListNode l3 = dummyRoot;
        // init a carry variable to 0
        int carry = 0;
        int sum;
        int x;
        int y;

        // loop over the size of the biggest ListNode
        while (l1 != null || l2 != null) {
            x = (l1 != null) ? l1.val : 0;
            y = (l2 != null) ? l2.val : 0;
            // Add l1 and l2 + carry at given index,
            // storing the 10s place into carry var and the sum into new ListNode
            sum = x + y + carry;
            l3.next = new ListNode(sum % 10);
            // Traverse next node
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;

            // store carry
            carry = sum / 10;
        }
        // Store carry into last node if > 0
        if (carry > 0) {
            l3.next = new ListNode(carry);
        }
        return dummyRoot.next;
    }
}
