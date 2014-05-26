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
        mergeTwoLists(head.next, l1, l2);
        return head.next;
        
    }

    private void mergeTwoLists(ListNode pointer, ListNode l1, ListNode l2){
        if(l1==null){
            pointer = l2;
        }else if(l2==null){
            pointer = l1;
        }else if(l1.val<=l2.val){
            pointer = l1;
            mergeTwoLists(pointer.next, l1.next, l2);
        }else{
            pointer = l2;
            mergeTwoLists(pointer.next, l1, l2.next);
        }
    }
  
}
