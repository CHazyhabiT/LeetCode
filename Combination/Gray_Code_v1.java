public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n<0) return result;
        int ele = 0;
        result.add(ele);

        for(int i=1;i<=n;++i){
            ele = grayCode(result, ele, i);

            
        }
        
        
        return result;
        
        
    }
    
    private int grayCode(ArrayList<Integer> result, int ele, int n){
        if(n==0) return ele;
        int mask = 1 << (n-1);
        ele ^= mask;
        result.add(ele);
        for(int i=1;i<n;++i){
        	ele = grayCode(result, ele, i);
        }
        return ele;
        
        
        
        
    }
    
    
    
}
