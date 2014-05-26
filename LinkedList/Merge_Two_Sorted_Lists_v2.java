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
        head.next = mergeTwoLists(head.next, l1, l2);
        return head.next;
        
    }
    
    private ListNode mergeTwoLists(ListNode pointer, ListNode l1, ListNode l2){
        if(l1==null&l2==null) return null;
        if(l1==null){
            pointer = l2;
            return pointer;
        }
        if(l2==null){
            pointer = l1;
            return pointer;
        }
        if(l1.val<=l2.val){
            pointer = l1;
            pointer.next = mergeTwoLists(pointer.next, l1.next, l2);
        }else{
            pointer = l2;
            pointer.next = mergeTwoLists(pointer.next, l1, l2.next);
        }
        return pointer;
        
        
        
        
        
    }
}
