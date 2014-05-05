// Chester

// Top_down
// DP, level order, one pass
// Storage : O(n) n is the number of last line's element

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.size()==0||triangle.get(0).size()==0) return 0;
        int height = triangle.size();
        ArrayList<Integer> parent = new ArrayList<Integer>();
        parent.add(triangle.get(0).get(0));
        int minSum = parent.get(0);
        ArrayList<Integer> child = new ArrayList<Integer>();
        for(int i=1;i<height;++i) {
            ArrayList<Integer> temp = triangle.get(i);
            child.clear();
            child.add(temp.get(0)+parent.get(0));
            minSum = temp.get(0) + parent.get(0);
            for(int j=0;j<parent.size();++j) {
                int first = temp.get(j) + parent.get(j);
                int second = temp.get(j+1) + parent.get(j);
                if(child.get(j)>first) {
                    child.remove(j);
                    child.add(first);
                }
                child.add(second);
                if(minSum>first||minSum>second) {
                    minSum = first < second ? first : second;
                }
                
            }
            parent = new ArrayList<Integer>(child);
   
        }
        return minSum;
        
    }
}
