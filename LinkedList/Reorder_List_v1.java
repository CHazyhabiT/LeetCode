// Chesster

// reverse the second half
// O(n) time and O(1) space

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
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode start = head;
        ListNode reversedNode = splitList(head.next);
        ListNode current = head;
        while(reversedNode!=null) {
            ListNode temp = current.next;
            ListNode tempReversedNode = reversedNode.next;
            current.next = reversedNode;
            reversedNode.next = temp;
            current = temp;
            reversedNode = tempReversedNode;
        }
        
    }
    
    private ListNode splitList(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode pointer = head;
        ListNode runner = head.next;
        while(runner!=null&&runner.next!=null) {
            runner = runner.next.next;
            pointer = pointer.next;
        }
        //if(runner!=null) pointer = pointer.next;
        
        ListNode pre = null;
        ListNode temp = pointer.next;
        pointer.next = null;
        pointer = temp;
        while(pointer!=null) {
            ListNode next = pointer.next;
            pointer.next = pre;
            pre = pointer;
            pointer = next;
        }
        return pre;
    }
}
