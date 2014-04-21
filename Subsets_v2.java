// Chester

// BFS
// each time choose an element to add into existed arrays
// time = 1 + 2^0 + 2^1 + ... + 2^(n-1) = 2^n
 


import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int ele : S) {
            int len = result.size(); // since result is dynamically changed
            for(int i=0;i<len;++i) { // for(int i=0;i<result.size()) will cause ConcurrentModificationException
                ArrayList<Integer> newLs = new ArrayList<Integer>(result.get(i));
                newLs.add(ele);
                result.add(newLs);
            }
        }
        return result;
    }
    
}
