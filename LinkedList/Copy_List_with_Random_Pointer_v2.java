// Chester

// O(n) time and O(1) space
// 1. traverse the original list, for each node, create new and add it after the original node
// eg: 17->23->6->14->32->null
// after step 1: 17->17->23->23->6->6->14->14->32->32->null
// 2. traverse the new list, the copied random node is the next node of the original random node,
//    which could be located by the original node
// 3. retraverse new list, split the list into original and copied lists

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return head;
        RandomListNode current = head;
	// duplicate the nodes
        while(current!=null) {
            RandomListNode temp = current.next;
            RandomListNode newNode = new RandomListNode(current.label);
            current.next = newNode;
            newNode.next = temp;
            current = temp;
        }
        // point the copied nodes to their random nodes
        current = head;
        while(current!=null) {
            RandomListNode random = current.random;
            if(random!=null) {
                RandomListNode copy = current.next;
                copy.random = random.next;
            }
            current = current.next.next;
        }
        // split the nodes
        current = head;
        RandomListNode preHead = new RandomListNode(0);
        RandomListNode copyCurrent = preHead;
        while(current!=null) {
            RandomListNode copy = current.next;
            current.next = copy.next; // this will avoide violating the original list
            current = copy.next;
            copyCurrent.next = copy;
            copyCurrent = copy;
        }
        
        return preHead.next;
        
        
        
    }
}
