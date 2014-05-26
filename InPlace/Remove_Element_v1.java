// Chester

public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length<=0) return 0;
        int move = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i]==elem) {
                move++;
            } else exch(A, i, i-move);
        }
        return A.length-move; 
    }
    
    private void exch(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
