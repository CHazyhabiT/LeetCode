// Chester

// 2 Pass

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k<=1) return head;
        ListNode preHead = new ListNode(0); // more convinient
        ListNode pre = preHead; 
        ListNode current = head;
        ListNode runner = head; // test whether the rest nodes should be converted
        while(current!=null) {
            int count = 1;
            while(runner.next!=null&&count<k) {
                ++count;
                runner = runner.next;;
            }
            runner = runner.next; // runner also keep the head of the next k-group nodes
            if(count==k) pre = reverseKGroup(current, pre, k); // if ==k, reverse
            else pre.next = current; // if not, keep the same sequence
            current = runner; // each round of the loop, current and runner should point to the same node
        }
        return preHead.next;
        
    }
    
    // pre.next will link to the head of the reversed list
    // and this private funciton will return the tail of the reversed list
    private ListNode reverseKGroup(ListNode head, ListNode pre, int k) {
        if(head==null||head.next==null) {
            pre.next = head;
            return head;
        }
        ListNode tail = head;
        ListNode preNode = null;
        ListNode current = head;
        int count = 0;
        while(current!=null&&count<k) {
            ++count;
            ListNode temp = current.next;
            current.next = preNode;
            preNode = current;
            current = temp;
        }
        pre.next = preNode;
        return tail;
    }
    
}
