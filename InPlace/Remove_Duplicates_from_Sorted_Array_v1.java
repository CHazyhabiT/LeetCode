public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<=1) return A.length;
        int nLen = A.length;
        int count = 0;
        int pointer = 1;
        for(int i=0;i<nLen;++i){
            
            while(pointer<A.length&&A[i]==A[pointer]){
                ++count;
                ++pointer;
                --nLen;
                
            }
            if(pointer<A.length){
                A[pointer-count] = A[pointer];
                ++pointer;
            }
            
            
            
            
            
        }
        return nLen;
        
        
    }
    

}
