/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode pointer = head;
        ListNode runner = head.next;
        while(runner.next!=null&&runner.next.next!=null){
            runner = runner.next.next;
            pointer = pointer.next;
            if(runner==pointer) return true;
        }
        return false;

    }
}
