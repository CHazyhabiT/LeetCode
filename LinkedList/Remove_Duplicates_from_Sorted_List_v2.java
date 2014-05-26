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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        int preVal = head.val;
        ListNode previous = head;
        ListNode current = head.next;
        while(current!=null) {
            if(current.val==preVal) {
                previous.next = current.next;
            } else {
                previous = current;
                preVal = current.val;
            }
            current = current.next;
        }
        return head;
  
    }
}
