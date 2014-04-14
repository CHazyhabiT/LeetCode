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
    public ListNode sortList(ListNode head) {
 
		if(head==null||head.next==null) return head;
		ListNode pointer = head;
		ListNode runner = head.next;
		while(runner.next!=null&&runner.next.next!=null){
		    runner = runner.next.next;
		    pointer = pointer.next;
		}
		ListNode p2 = pointer.next;
		pointer.next = null;
		return mergeList(sortList(head), sortList(p2));
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2){
        if(l1==null&&l2==null) return null;
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode current = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1!=null) current.next = l1;
        else current.next =l2;
        return head.next;
    }
    
    
    
    
    
}
