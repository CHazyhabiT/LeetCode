// Chester

// Binary search: O(logN)
public class Solution {
    public int searchInsert(int[] A, int target) {
        int length = A.length;
        return searchInsert(A, 0, length-1, target);
        
    }
    
    private int searchInsert(int[] A, int i, int j, int target){
        if(i>j) return i;
        int mid = (i+j)/2;
        if(A[mid]==target) return mid;
        else if(A[mid]<target) return searchInsert(A, mid+1, j, target);
        else return searchInsert(A, i, mid-1, target);

    }
    
    
    
}
