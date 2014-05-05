// Chester

// 1. in the process of inserting sort, need to reverse the linked-list gradually
// 2. finally need to reverse the linked-list again
// 3. O(n^2) worst case, O(n) best case

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
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre = head;
        ListNode current = head.next;
        pre.next = null; // important
        while(current!=null) {
            ListNode tempPre = pre; // important
            ListNode tempCur = current; // important
            while(tempPre!=null) {
                if(tempCur.val<tempPre.val) {
                    int temp = tempCur.val;
                    tempCur.val = tempPre.val;
                    tempPre.val = temp;
                    tempCur = tempPre;
                    tempPre = tempPre.next;
                    
                }else break;
            }
            ListNode tempNode = current;
            current = current.next;
            tempNode.next = pre;
            pre = tempNode;
        }
        
        return reverse(pre);
 
    }
    
    // given a linked-list, reverse it
    private ListNode reverse(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode current = head;
        ListNode next = head.next;
        current.next = null; // important
        while(next!=null) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        return current;
        
        
        
    }
    
}
