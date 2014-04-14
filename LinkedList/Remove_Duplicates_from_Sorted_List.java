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
 import java.util.HashSet;
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(head.val);
        ListNode node = head;
        while(node.next!=null){
            int val = node.next.val;
            if(hs.contains(val))
                node.next = node.next.next;
            else{
                hs.add(val);
                node = node.next;
            }
            
        }
        return head;
        
        
    }
}
