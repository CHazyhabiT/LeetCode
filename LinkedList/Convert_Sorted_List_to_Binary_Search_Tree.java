// Chester

// to build a height balanced tree asks for starting add numbers in the middle of an array
// given a linked list, first split into two halves, each list is represented by its start node
// 	-- splitLinkedList(ListNode node) will do such thing
// 	-- it will return ListNode[] : {start_node_l1, start_node_l2}
//	-- when given linked list contains only one node, it will return {null, start_node_l2}
// use the returned value, build the BST

// time complexity
// = (n/2)*1 + (n/4)*2 + (n/8)*4 + ... + (n/(2^x))*(2^(x-1)) = n/2 * logn = O(nlogn)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode[] lNodes = splitLinkedList(head);
        int midVal = lNodes[1].val;
        TreeNode tNode = new TreeNode(midVal);
        tNode.left = sortedListToBST(lNodes[0]);
        tNode.right = sortedListToBST(lNodes[1].next);
        return tNode;
    }
    
    // given a start node of a linked list
    // return the mid node, and break the linked list into half
    private ListNode[] splitLinkedList(ListNode node) {
        ListNode[] lNodes = new ListNode[2];
        if(node==null) return lNodes;
        if(node.next==null) {
            lNodes[1] = node;
            return lNodes;
        }
        ListNode pointer = node;
        ListNode runner = node.next;
        while(runner.next!=null&&runner.next.next!=null) {
            pointer = pointer.next;
            runner = runner.next.next;
        }

        lNodes[0] = node;
        lNodes[1] = pointer.next;
        pointer.next = null;
        return lNodes;

    }
    
    
    
    
    
    
    
    
}
