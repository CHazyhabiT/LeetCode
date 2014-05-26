// Chester

// O(n) time and space
// use HashMap to store the already created nodes
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
        HashMap<Integer, RandomListNode> hm = new HashMap<Integer, RandomListNode>();
        RandomListNode current = head;
        RandomListNode preHead = new RandomListNode(0);
        RandomListNode copyCurrent = preHead;
        while(current!=null) {
            int label = current.label;
            RandomListNode copyNode;
            if(!hm.containsKey(label)) {
                copyNode = new RandomListNode(label);
                hm.put(label, copyNode);
            } else {
                copyNode = hm.get(label);
            }
            copyCurrent.next = copyNode;
            copyCurrent = copyNode;
            RandomListNode randomNode = current.random;
            current = current.next;
            if(randomNode!=null) {
                int randomLabel = randomNode.label;
                if(!hm.containsKey(randomLabel)) {
                    RandomListNode copyRandomNode = new RandomListNode(randomLabel);
                    copyNode.random = copyRandomNode;
                    hm.put(randomLabel, copyRandomNode);
                } else {
                    RandomListNode copyRandomNode = hm.get(randomLabel);
                    copyNode.random = copyRandomNode;
                }
            }
        }
        return preHead.next;
        
    }
}
