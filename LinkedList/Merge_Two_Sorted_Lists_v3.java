// Chester

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode h1 = l1;
        ListNode h2 = l2;
        while(h1!=null&&h2!=null) {
            if(h1.val<=h2.val) {
                current.next = h1;
                h1 = h1.next;
            } else {
                current.next = h2;
                h2 = h2.next;
            }
            current = current.next;
        }
        if(h1==null) current.next = h2;
        if(h2==null) current.next = h1;
        return head.next;
        
    }
}
