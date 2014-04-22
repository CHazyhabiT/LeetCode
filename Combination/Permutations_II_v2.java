// Chester

// DFS
// compared with permutations of the array with distinct numbers
// 1. need to sort the array fisrt
// 2. then when visit one node num[index]
// 	-- first to check whether it is the same with previous one num[index-1]
//	-- if: it is the same, if the previous one hasn't been visited, then: current one cannot be visited
//	-- else: the current one could be visited

// O(N!) 
import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length==0) return result;
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
	// default of the objects in visited is false
        boolean[] visited = new boolean[num.length];
	// Arrays.sort(visited, false) is not necessary
        for(int i=0;i<num.length;++i) {
            permuteUnique(num, result, list, visited, i);
        }
        return result;
        
    }
    
    private void permuteUnique(int[] num, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, boolean[] visited, int index) {
	// the only condition the current one could not be visited
        if(index>=1&&num[index]==num[index-1]&&visited[index-1]==false) return;         
	visited[index] = true;
        ArrayList<Integer> newList = new ArrayList<Integer>(list);
        newList.add(num[index]);
        if(newList.size()==num.length) result.add(newList);
        else {
            for(int i=0;i<num.length;++i) {
                if(visited[i]==false)
                    permuteUnique(num, result, newList, visited, i);
            }
        }
        visited[index] = false; // important
        
    }
}
