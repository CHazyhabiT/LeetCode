// Chester

// build two linked list
// one => nodes less than x
// one => nodes greater or equal than x

// this solution will change the order
// example: 1->4->3->2->5->2 and x = 3
// return: 1->2->2->5->3->4

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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode smallerH = new ListNode(0);
        ListNode smallerT = smallerH;
        ListNode greater = null;
        ListNode node = head;
        while(node!=null) {
            int value = node.val;
            if(value<x) {
                smallerT.next = node;
                smallerT = node;
                node = node.next;
            }else {
                if(greater==null) {
                    greater = new ListNode(value);
                    node = node.next;
                }else {
                    ListNode temp = node.next;
                    node.next = greater;
                    greater = node;
                    node = temp;
                    
                }
                
            }
        }
	smallerT.next = greater;
        return smallerH.next;
	
	                
    }
}
