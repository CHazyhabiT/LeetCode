ipublic class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ls = new ArrayList<Integer>();
        if(n<0||n*k==0||k>n) return result;
        combine(n, k, 1, result, ls);
        return result;
        
        
    }
    
    private void combine(int n, int k, int current, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ls) {
        if(k==0) {
            result.add(ls);
            return;
        }
        //if(current>n) return;
        if((n-current+1)<k) return; // this stop condition will be better
        ArrayList<Integer> newLs = new ArrayList<Integer>(ls);
        newLs.add(current);
        combine(n, k-1, current+1, result, newLs);
        combine(n, k, current+1, result, ls);

    }
    
}
