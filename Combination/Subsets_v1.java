// Chester

// O(k) = (n-k+1)*O(k-1)
// time = O(0) + O(1) +...+ O(n)

import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        int len = S.length;
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=len;++i) {
            subsets(S, i, result);
        }
        return result;
    }
    
    // choose k elements of S and add to result
    private void subsets(int[] S, int k, ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        helper(S, k, 0, result, set);
    }
    
    // choose k elments from S[p, p+1, ..., n-1], 
    // combined with set to form a new set,
    // add this new set into result
    private void helper(int[] S, int k, int p, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> set) {
        if(k==0) {
            result.add(set);
            return;
        }
        if(S.length-p>=k) {
            ArrayList<Integer> newSet = new ArrayList<Integer>(set);
            newSet.add(S[p]);
            helper(S, k-1, p+1, result, newSet); //if S[p] be choosen
            helper(S, k, p+1, result, set); // if S[p] not be choosen
        }

    }
    
}
