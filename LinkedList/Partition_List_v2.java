// Chester

// build two linked list
// one => nodes less than x
// one => nodes greater or equal than x

// this solution will change the order
// example: 1->4->3->2->5->2 and x = 3
// return: 1->2->2->4->3->5


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
        ListNode greaterH = new ListNode(0);
        ListNode greaterT = greaterH;
        ListNode node = head;
        while(node!=null) {
            int value = node.val;
            if(value<x) {
                ListNode temp = node.next;
                smallerT.next = node;
                smallerT = node;
                node.next = null;
                node = temp;
            }else {
                ListNode temp = node.next;
                greaterT.next = node;
                greaterT = node;
                node.next = null;
                node = temp;
                
            }
        }
        smallerT.next = greaterH.next;
        return smallerH.next;

	// compared with code above, the following will cause a infinite loop
	// which will cause Time-Limit-Exceeded
	// reason: when smallerT.next = greaterH.next;
	// this wll lead to post node point to the previous node
	
	// test case: 2->1, x = 2 will cause Time-Limit-Exceeded
	//The node 2 is taken and placed into the greater list, but its next value is still pointing at node 1. Node 1 is then placed into the lesser list, and its next is assigned to the start of the greater list, node 2, after the while loop ends. 

	/*
	while(node!=null) {
            int value = node.val;
            if(value<x) {
                smallerT.next = node;
                smallerT = node;
                node = node.next;
            }else {
                greaterT.next = node;
                greaterT = node;
                node = node.next;
                
            }
        }
	smallerT.next = greaterH.next;
        return smallerH.next;
	*/

        
    }
}
