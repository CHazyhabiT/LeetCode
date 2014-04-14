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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n<=0) return head;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pointer = root;
        ListNode runner = root;
        for(int i=0;i<n;++i) {
            runner = runner.next;
        }
        while(runner.next!=null) {
            pointer = pointer.next;
            runner = runner.next;
        }
        pointer.next = pointer.next.next;
        return root.next;
  
    }
}
