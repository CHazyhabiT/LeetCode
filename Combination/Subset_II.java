// Chester

// adopt HashSet to record the duplicates
// time = 1 + 2^0 + 2^1 + ... + 2^(n-1) = 2^n
// space: worst case is 2^n
import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(len<=0) return result;
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int i=0;i<len;++i) {
            // hs.clear();
            int lenR = result.size();
            for(int j=0;j<lenR;++j) {
                ArrayList<Integer> ls = new ArrayList<Integer>(result.get(j));
                ls.add(num[i]);
                if(!hs.contains(ls)) {
                    result.add(ls);
                    hs.add(ls);
                }
            }
        }
        return result;
        
        
    }
}
