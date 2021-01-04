/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (34.89%)
 * Total Accepted:    1.7M
 * Total Submissions: 4.9M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 *
 * Example 2:
 *
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 *
 * Example 3:
 *
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have
 * leading zeros.
 *
 *
 */
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
