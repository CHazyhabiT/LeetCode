// Chester

// basic operation is to merge two lists

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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size()==0) return null;
        ListNode mergedList = lists.get(0);
        for(int i=1;i<lists.size();++i) {
            mergedList = merge2Lists(mergedList, lists.get(i));
        }
        return mergedList;
        
        
    }
    
    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode preHead = new ListNode(0);
        ListNode current = preHead;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while(p1!=null&&p2!=null) {
            int val1 = p1.val;
            int val2 = p2.val;
            if(val1<=val2) {
                current.next = p1;
                current = p1;
                p1 = p1.next;
            }else {
                current.next = p2;
                current = p2;
                p2 = p2.next;
            }
        }
        if(p1==null) current.next = p2;
        if(p2==null) current.next = p1;
        return preHead.next;
    }
}
