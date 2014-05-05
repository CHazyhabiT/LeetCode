// Chester

// this method aims to maintain the length of consecutive sequence (at start and end of this sequence)

// method 3: The intuitive idea is to 'chain' the consecutive numbers together. To do this, we can set up a parent and a child pointer, i.e., parent[i] = j means the parent of num[i] is j. To be efficient, you need to use a hash map to map the value to its index in the array.

// After you construct the chain, given any number v of index i, you can simply, traverse parent/child to get the length of chain, and mark the elements as visited. Thus, each element will only be visited once.

import java.util.HashMap;
public class Solution {
    public int longestConsecutive(int[] num) {
        if(num==null||num.length==0) return 0;
        int hashL = (int) num.length*2;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(hashL);
        int max = 1;
        for(int n : num) {
            int numL = 0;
            int numR = 0;
            if(hm.containsKey(n)) continue; // duplicates will ruin this method
            
            if(n-1>=Integer.MIN_VALUE&&hm.containsKey(n-1)) {
                numL = hm.get(n-1);
            }
            if(n+1<=Integer.MAX_VALUE&&hm.containsKey(n+1)) {
                numR = hm.get(n+1);
            }
            int len = 1 + numL + numR;
            
            if(n-1>=Integer.MIN_VALUE&&hm.containsKey(n-numL)) { // only update the farest number it can get
                numL = hm.put(n-numL, len);
            }
            if(n+1<=Integer.MAX_VALUE&&hm.containsKey(n+numR)) {
                numR = hm.put(n+numR, len);
            }
            hm.put(n, len);
            max = Math.max(max, len);

        }
        return max;
        
        
    }
}
