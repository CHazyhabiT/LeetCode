public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        if (n <= 2) return n;       // no need to deal with n<=2 case.
        int len = 2;
        int itor = 2;
        while (itor < n) {
            if (A[itor] != A[len-2]) 
                A[len++] = A[itor];
            itor++;
        }
        return len;
        
    }

}
