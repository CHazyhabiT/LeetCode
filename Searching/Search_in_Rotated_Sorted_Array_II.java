public class Solution {
    public boolean search(int[] A, int target) {
        if(A.length<=0) return false;
        int start = 0;
        int end = A.length - 1;
        while(A[start]==A[end]&&start<end) --end;
        if(A[start]<=A[end]){
            return binarySearch(A, start, end, target);
        }else {
            int minLoc = locateMin(A, start, end);
            if(target<=A[end])
                return binarySearch(A, minLoc, end, target);
            else return binarySearch(A, start, minLoc-1, target);
            
        }
    
    }
    
    private boolean binarySearch(int[] A, int start, int end, int target) {
        while(start<=end) {
            int median = (start + end) / 2;
            if(A[median]==target) return true;
            else if(A[median]>target) end = median - 1;
            else start = median + 1;
            
        }
        return false;

    }
    
    private int locateMin(int[] A, int start, int end) {
        while(start<=end) {
            int median = (start + end) / 2;
            if(A[median]>A[end]) {
                start = median + 1;
                
            }else {
                if(A[median]<A[median-1]) return median;
                else end = median - 1;

            }
        }
        return -1;
        
        
    }
    

}
