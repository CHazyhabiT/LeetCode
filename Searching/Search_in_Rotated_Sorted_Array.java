// Chester

// a genral way of binary search: O(logN)

public class Solution {
    public int search(int[] A, int target) {
        if(A.length<=0) return -1;
        int start = 0;
        int end = A.length - 1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(target==A[mid]) return mid;
            if(A[start]<=A[mid]) { // left half is sorted
                if(A[start]<=target&&target<A[mid]) { // if target lies on the sorted left half
                    end = mid - 1;
                    
                }else {
                    start = mid + 1;
                    
                }
            }else { // right half is sorted
                if(A[mid]<target&&target<=A[end]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            
            }
        }
        return -1;
    }
    
}
