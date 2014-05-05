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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode start = new ListNode(0);
        ListNode pre = start;
        ListNode reverseH = null;
        ListNode reverseT = reverseH;
        ListNode node = head;
        while(count<m) {
            pre.next = node;
            pre = node;
            node = node.next;
            ++count;
        }
                
        while(count<=n) {
            if(reverseT==null) {
                reverseT = node;
                reverseH = node;
                node = node.next;
            }else {
                ListNode temp = node.next;
                node.next = reverseH;
                reverseH = node;
                node = temp;
            }
            ++count;
        }
        pre.next = reverseH;
        reverseT.next = node;
        return start.next;

        
    }
}
