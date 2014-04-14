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
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slower = head;
        ListNode runner = head.next;
        if(runner==null) return null;
        while(runner!=null) {
            if(runner.next!=null&&runner.next.next!=null) {
                if(slower==runner) break;
                slower = slower.next;
                runner = runner.next.next;
            }else return null;
        }
        runner = runner.next;
        slower = head;
        while(runner!=slower) {
            runner = runner.next;
            slower = slower.next;
        }
        return slower;
    }
}
