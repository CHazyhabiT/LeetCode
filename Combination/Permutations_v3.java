// Chester

// DFS
// when visited a node, mark it visited

// O(N!)
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if(len==0) return result;
        ArrayList<Integer> tuple = new ArrayList<Integer>();
        boolean[] mark = new boolean[len]; // symbol of the DFS
	// DFS asks for a start point
        for(int i=0;i<len;++i) {
            permute(result, tuple, num, mark, i);
            
        }
        return result;
        
        
    }
    
    private void permute(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tuple, int[] num, boolean[] mark, int index) {
        mark[index] = true;
        // another way of copying an ArrayList
        ArrayList<Integer> newTuple = new ArrayList<Integer>(tuple);
        newTuple.add(num[index]);
        if(newTuple.size()==num.length) result.add(newTuple);
        for(int i=0;i<num.length;++i) {
            if(mark[i]==false) {
                permute(result, newTuple, num, mark, i);
            }
        }
        mark[index] = false;
 
    }
}
