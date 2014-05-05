// Chester

// test cases:
// 1 2
// 1 1 
// 1 1 2
// 1 1 2 2 
// 1 1 2 2 3 

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode preHead = new ListNode(0); // more convinient if head should be deleted
        ListNode pre = preHead; // point to previous node
        ListNode current = head; // point to current node
        boolean isDelete = false; // flag whether the current node should be deleted
        while(current!=null) {
            if(current.next!=null) {
                if(current.val!=current.next.val) {
                    if(!isDelete) { // important
                        isDelete = false;
                        pre.next = current;
                        pre = current;
                    }else isDelete = false;
                }else isDelete = true;
            }else {
                if(isDelete) pre.next = null; // important
                else pre.next = current;
            }
            current = current.next;
        }
        return preHead.next;
        
    }
}
