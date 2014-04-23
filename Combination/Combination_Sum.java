// Chester

// recursively combinationSum(candidates, target, index)
// 	-- i = [0, index], each time choose a number from candidates: candidates[i]
//	-- get satisfied situation of repeated candidates[i]
// 	-- for each situation
//		-- if sum==target, add this to result
//		-- else, combinationSum(candidates, target-sum, i-1)

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = candidates.length;
        if(len==0) return result;

        Arrays.sort(candidates);
        
        result = combinationSum(candidates, target, len-1);
        return result;
    }
    
    // given a range of numbers (increasing order) and target, find all the ...
    private ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int index) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(index<0) return result; // if result.size()==0, it means there is no such combination
        for(int i=index;i>=0;--i) {
            int num = candidates[i];
            
            // compute the maximum number of candidates[i] could contribute to target
            int count = 1;
            int sum = num*count;
            while(sum<=target) {
                ++count;
                sum = num*count;
            }
            --count;

            for(int j=count;j>=1;--j) {
                int rest = target - num*j;
                if(rest==0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for(int k=0;k<j;++k) {
                        list.add(num);
                    }
                    result.add(list);
                    
                }else {
                    ArrayList<ArrayList<Integer>> restResult = combinationSum(candidates, rest, i-1);
                    if(restResult.size()!=0) {
                        for(ArrayList<Integer> list : restResult) {
                            ArrayList<Integer> newList = new ArrayList<Integer>(list);
                            for(int k=0;k<j;++k) {
                                newList.add(num);
                            }
                            result.add(newList);
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
}
