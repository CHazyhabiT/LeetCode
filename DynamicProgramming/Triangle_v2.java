// Chester

// Bottom up
// compared with top down, we don't need to maintain the minimum sum
// in place algorithm, but the input triangle has been changed

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle==null||triangle.size()==0||triangle.get(0).size()==0) return 0;
        int height = triangle.size();
        ArrayList<Integer> parent = triangle.get(height-1);
        for(int i=height-2;i>=0;--i) {
            ArrayList<Integer> current = triangle.get(i);
            for(int j=0;j<current.size();++j) {
                int sum1 = current.get(j) + parent.get(j);
                int sum2 = current.get(j) + parent.get(j+1);
                int minSum = sum1 < sum2 ? sum1 : sum2;
                current.remove(j);
                current.add(j, minSum);
                
                
            }
            parent = current;
        }
        
        return parent.get(0);
        
        
    }
}
