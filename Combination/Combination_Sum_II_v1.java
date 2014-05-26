// Chester

// function(int[] num, int target, int range, HashSet hs, boolean mark)
// 	-- given num, target, find combinations satisfied in [0, range]
//	-- hs is used to record the combinations already found
// 	-- in our algorithm, since our function will be recursively called,
//	-- we want the hs to only record the finaly result, so we use a mark to flag

import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length==0||target<=0) return result;
        Arrays.sort(num); // important
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        return combinationSum2(num, target, num.length-1, hs, true);
    }
    
    private ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target, int range, 
        HashSet<ArrayList<Integer>> hs, boolean mark) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	// target <= 0, means in the given array, we don't need or cannot find such combinations
        if(target<=0) return result;
 	// get new range in order to traverse from the element in num which <= target
        while(range>=0) {
            if(num[range]<=target) break;
            --range;
        }
        if(range<0) return result;
        // start traverse
        for(int i=range;i>=0;--i) {
            int rest = target - num[i];
            if(rest==0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(num[i]);
                if(mark) {
                    if(!hs.contains(temp)) {
                        result.add(temp);
                        hs.add(temp);
                    }
                }else result.add(temp);
            }else {
                ArrayList<ArrayList<Integer>> preResult = combinationSum2(num, rest, i-1, hs, false);
                // preResult.size()==0 means we cannot find satisfied combinations in previous array
		if(preResult.size()>0) {
                    for(ArrayList<Integer> list : preResult) {
                        ArrayList<Integer> newList = new ArrayList<Integer>(list);
                        newList.add(num[i]);
                        if(mark) {
                            if(!hs.contains(newList)) {
                                result.add(newList);
                                hs.add(newList);
                            }
                        }else result.add(newList);
                    }
                }
            }
        }
        return result;
    }
}
