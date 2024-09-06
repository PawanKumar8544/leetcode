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
    public ListNode modifiedList(int[] nums, ListNode head) {
          int maxv = 0;
        for (int v : nums) {
            maxv = Math.max(maxv, v);
        }
        boolean[] rem = new boolean[maxv + 1];
        for (int v : nums) {
            rem[v] = true;
        }
        ListNode h = new ListNode(0);
        ListNode t = h;
        ListNode p = head;
        while (p != null) {
            if (p.val > maxv || !rem[p.val]) {
                t.next = p;
                t = p;
            }
            p = p.next;
        }
        t.next = null;
        return h.next; 
    }
}