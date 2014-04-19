public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(n<0||k>n) return result;
        if(k==0) {
            ArrayList<Integer> ele = new ArrayList<Integer>();
            result.add(ele);
            return result;
        }
        if(n==1&&k==1) {
            ArrayList<Integer> ele = new ArrayList<Integer>();
            ele.add(1);
            result.add(ele);
            return result;
        }
        
        for(int i=k;i<=n;++i) {
            ArrayList<ArrayList<Integer>> temp = combine(i-1, k-1);
            for(ArrayList<Integer> ele : temp) {
                ele.add(i);
                result.add(ele);
            }
        }
        return result;
        
        
        
        
    }
}
