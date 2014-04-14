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
        ListNode head = null;
        ListNode current = null;
        int sum = 0;
        int carry = 0;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1!=null&&l2==null){
                sum = l1.val + carry;
                l1 = l1.next;
            }else{
                sum = l2.val + carry;
                l2 = l2.next;
            }
            carry = sum / 10;
            ListNode temp = current;
            current = new ListNode(sum % 10);
            if(head==null) head = current;
            else temp.next = current;
        
        }
        if(carry>0){
            ListNode temp = current;
            current = new ListNode(carry);
            temp.next = current;
        }
        return head;
   
    }
}
