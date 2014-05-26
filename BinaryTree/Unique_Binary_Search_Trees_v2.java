// Chester

// DP
// recursively
public class Solution {
    public int numTrees(int n) {
        if(n<=0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int result = 0;
        for(int i=0;i<n;i++) {
            int left = 1;
            if(i!=0) left = numTrees(i);
            int right = 1;
            if(i!=n-1) right = numTrees(n-i-1);
            result += left * right;
  
        }
        return result;
    
        
    }
}
