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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        ListNode root = addTwoNumbers(l1, l2, 0);
        return root;
   
    }
    
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if(l1==null&&l2==null&&carry==0) return null;
        int sum = carry;
        if(l1!=null){
            sum += l1.val;
            l1 = l1.next;
        } 
        if(l2!=null){
            sum += l2.val;
            l2 = l2.next;
        } 
        ListNode node = new ListNode(sum%10);
        node.next = addTwoNumbers(l1, l2, sum/10);

        return node;
   
    }
    
    
    
    
    
    
}
