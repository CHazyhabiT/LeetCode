public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len<=0) return 0;
        int move = 0;
        int tag = 1;
        int pre = A[0];
        for(int i=1;i<len;++i) {
            moveE(A, i, move);
            if(A[i]==pre) {
                if(++tag>=3) {
                    ++move;
                }
                
            }else {
                tag = 1;
                pre = A[i];
            }
            
        }
        return len - move;
        
    }
    private void moveE(int[] A, int current, int move) {
        A[current-move] = A[current];
    }
}
