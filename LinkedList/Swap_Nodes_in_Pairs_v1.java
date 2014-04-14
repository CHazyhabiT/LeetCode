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
        if(head==null||head.next==null) return head;
        ListNode start = new ListNode(0);
        ListNode current = start;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p1!=null&&p2!=null){
            ListNode temp = p2.next;
            
            current.next = p2;
            p2.next = p1;
            current = p1;
            
            if(temp!=null){
                p1 = temp;
                if(temp.next!=null)
                    p2 = temp.next;
                else p2 = null;
                
            }else{
                p1 = null;
                p2 = null;
            }
            
            
        }
        current.next = p1;
        
        return start.next;
        
        
        
        
        
    }
}
