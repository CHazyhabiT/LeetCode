public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int len = m + n;
        int pA = m - 1;
        int pB = n - 1;
        for(int p=len-1;p>=0;--p){
            if(pA>=0&&pB>=0){
                if(A[pA]<=B[pB]){
                    A[p] = B[pB--];
                }else A[p] = A[pA--];
            }else if(pB>=0){
                A[p] = B[pB--];
            }else break;
            
        }
        
        
    }
}
