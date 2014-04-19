public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n<0) return result;
        if(n==0) {
            result.add(0);
            return result;
        }else {
            int mark = 1 << (n-1);
            result = grayCode(n-1);
            int len = result.size();
            for(int i=len-1;i>=0;--i) {
                result.add(result.get(i)|mark);
            }
        }
        
        return result;
    }
    
    
    
}
