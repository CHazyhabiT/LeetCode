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
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = swapPairs(start.next, head);
        return start.next;
        
        
        
    }
    
    private ListNode swapPairs(ListNode node, ListNode head){
        if(head==null) return null;
        if(head.next==null){
            node = head;
            return node;
        }
        ListNode temp = head.next.next;
        
        node = head.next;
        head.next.next = head;
        head.next = swapPairs(head.next, temp);
        
        return node;
    }
    
}
