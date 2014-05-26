// Chester

// DFS
// dfs(int[] num, int target, int index, boolean[] mark)
// 	-- given num, target, find satisfied combination including num[index]
// 	-- mark used to mark whether the element has been traversed

import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length==0||target<=0) return result;
        Arrays.sort(num);
        boolean[] mark = new boolean[num.length];
        Arrays.fill(mark, false); // initially none of the elements been traversed
        for(int i=num.length-1;i>=0;--i) {
            ArrayList<ArrayList<Integer>> tempResult = dfs(num, target, i, mark);
            for(ArrayList<Integer> temp : tempResult) {
                result.add(temp);
            }
        }
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> dfs(int[] num, int target, int index, boolean[] mark) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(target<=0||index<0||num[index]>target) return result;

        if(index<num.length-1&&num[index]==num[index+1]&&mark[index+1]==false)
            return result;

        mark[index] = true; // flag of the DFS
        int rest = target - num[index];
        if(rest==0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(num[index]);
            result.add(list);
        }else {
            for(int i=index-1;i>=0;--i) {
                ArrayList<ArrayList<Integer>> preResult = dfs(num, rest, i, mark);
                if(preResult.size()>0) { // could delete this
		    // if preResult.size()==0, it won't jump into the for loop
                    for(ArrayList<Integer> list : preResult) {                        
			ArrayList<Integer> newList = new ArrayList<Integer>(list);
                        newList.add(num[index]);
                        result.add(newList);
                    }
                }
            }
            
        }
        mark[index] = false; // flag of the DFS
        
        return result;
    }
}
