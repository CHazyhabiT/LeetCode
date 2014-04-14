public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n<0) return result;
        result.add(0);
        for(int i=0;i<n;i++){
            int ele = 1 << i;
            int len = result.size();
            for(int j=len-1;j>=0;--j){
                result.add(ele|result.get(j));
                
            }
                
            
            
        }
        
        
        
        return result;
        
        
    }
    
    
    
}
