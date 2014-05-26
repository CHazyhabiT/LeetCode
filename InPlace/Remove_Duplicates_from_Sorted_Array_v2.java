// Chester

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<=1) return A.length;
        int count = 0;
        for(int i=1;i<A.length;++i){
            if(A[i]==A[i-1]){
                ++count;
            }else{
                A[i-count] = A[i];
            } 
        }
        return A.length - count; 
    }
}
