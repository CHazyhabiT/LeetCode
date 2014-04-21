// Chester

// search for the start and end position of target separately with binary search
// 2 * O(logN)

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] range = new int[2];
        if(A.length<=0) {
            Arrays.fill(range, -1);
            return range;
        }
        range[0] = binarySearchS(A, target);
        range[1] = binarySearchE(A, target);
        return range;
    }
    
    private int binarySearchS(int[]A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start<=end) {
            int mid = (start+end)/2; // get the mid position close to start
            if(target==A[mid]) {
                if(mid==start) return start;
                else end = mid; 
            }else if(target<A[mid]) {
                end = mid - 1;
            }else start = mid + 1;
        }
        return -1;
        
    }
    
    private int binarySearchE(int[]A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start<=end) {
            int mid = (start+end+1)/2; // get the mid position close to end
            if(target==A[mid]) {
                if(mid==end) return end;
                else start = mid; 
            }else if(target<A[mid]) {
                end = mid - 1;
            }else start = mid + 1;
        }
        return -1;
    }
}
