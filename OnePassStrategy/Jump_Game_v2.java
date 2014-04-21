// Chester

// less than one pass
public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length;
        int max = 0; // currently the max location we can jump to
        int current = 0; // current location
        while(current<=max) {
            if(current+A[current]>max) {
                max = current + A[current];
            }
            if(max>=len-1) return true;
            ++current;
            
        }
        return false;
        
    }
    
}
