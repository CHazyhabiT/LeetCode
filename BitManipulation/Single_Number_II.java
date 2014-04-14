public class Solution {
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        int result = 0;
        for(int i=0;i<count.length;i++){
            count[i] = 0;
            for(int j=0;j<A.length;j++)
                count[i] += A[j]>>i & 1;
            result |= count[i]%3 << i;
        }
        return result;
        
        
        
    }
}
