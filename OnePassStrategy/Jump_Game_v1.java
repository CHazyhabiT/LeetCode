// chester

// DP
// however, this will cause Time-Limit-Exceeded


public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length;
        return canJump(A, 0);
        
    }
    
    private boolean canJump(int[] A, int start) {
        int jump = A[start];
        if(start+jump>=A.length-1) return true;
        for(int i=1;i<=jump;++i) {
            boolean canJ = canJump(A, start+i);
            if(canJ==true) return true;
        }
        return false;
    }
}
