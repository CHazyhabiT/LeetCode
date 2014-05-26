// Chester

// O(n) time and space

import java.util.HashSet;
import java.util.Iterator;
public class Solution {
    public int singleNumber(int[] A) {
        if(A.length<1) return Integer.MIN_VALUE;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<A.length;i++){
            if(hs.contains(A[i])){
                hs.remove(A[i]);
            }else hs.add(A[i]);
        }
        
        Iterator<Integer> iter = hs.iterator();
        if(iter.hasNext())
            return iter.next();
        else return Integer.MIN_VALUE;
        
        
        
    }
}
