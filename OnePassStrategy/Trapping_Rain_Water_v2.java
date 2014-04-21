// Chester

// one than one pass but less than two pass
// constant space
// first left to right, then right to the highest value
public class Solution {
    public int trap(int[] A) {
        if(A.length<3) return 0;
        int rain = 0;
        int maxIndex = 0;
        int block = 0; // store the previous unhandled block
        for(int i=1;i<A.length;++i) {
            if(A[i]>=A[maxIndex]) {
                rain += (i-maxIndex-1)*A[maxIndex] - block;
                block = 0;
                maxIndex = i;
            }else {
                block += A[i];
            }
            
        }
        block = 0;
        int maximum = maxIndex;
        maxIndex = A.length - 1;
        for(int i=A.length-2;i>=maximum;--i) {
            if(A[i]>=A[maxIndex]) {
                rain += (maxIndex-i-1)*A[maxIndex] - block;
                block = 0;
                maxIndex = i;
            }else {
                block += A[i];
            }
            
        }
        
        return rain;
        
        
        
    }
    
}
