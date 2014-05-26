// Chester

// optimized: reduce the operation of exch();
public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length<1) return 0;
        int len = A.length;
        while(len>0&&A[len-1]==elem) len--;
        for(int i=0;i<len;i++){
            if(A[i]==elem){
                exch(A, i, len-1);
                while(len>0&&A[len-1]==elem) len--;
            }
        }
        return len;
    }
    
    private void exch(int[]  A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        
    }
}
