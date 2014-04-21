// Chester

// first delete the duplicated number in the end, make sure A[start] != A[end]
// if all the array are the same number, then O(N)
// else O(logN)

public class Solution {
    public boolean search(int[] A, int target) {
        if(A.length<=0) return false;
        int start = 0;
        int end = A.length - 1;
        while(A[start]==A[end]&&start<end) --end;
        while(start<=end) {
            int mid = (start+end)/2;
            if(target==A[mid]) return true;
            if(A[start]<=A[mid]) {
                if(A[start]<=target&&target<A[mid])
                    end = mid -1;
                else start = mid + 1;
                
            }else {
                if(A[mid]<target&&target<=A[end])
                    start = mid + 1;
                else end = mid - 1;
                
            }
        }
        return false;
        
    }
    

    

}
