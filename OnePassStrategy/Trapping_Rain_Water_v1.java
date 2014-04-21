// Chester

// two pass with O(N) extra space
// input: 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
// aid_A: 0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1
// aid_A - input = 6

// the idea is to first one pass input to find max
// then left and right pointer move from both sides to middle
public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if(len<=2) return 0;
        int[] aid = new int[len];
        int l = 0;
        int r = len-1;
        int sum = 0;
        int max = max(A);
        int preMax = 0;
        while(A[l]<max) { // be carefull, A[l]<=max will cause IndexOutofBound
            if(preMax<A[l]) preMax = A[l];
            aid[l] = preMax;
            ++l;
            
        }
        preMax = 0;
        while(A[r]<max) {
            if(preMax<A[r]) preMax = A[r];
            aid[r] = preMax;
            --r;
        }
        if(l!=r) {
            for(int i=l;i<=r;++i) {
                aid[i] = max;
            }
        } else aid[l] = max;
        for(int i=0;i<len;++i) {
            int diff = aid[i] - A[i];
            sum += diff;
        }
        return sum;
 
    }
    
    private int max(int[] A) {
        int max = 0;
        for(int val : A) {
            if(val>max) max = val;
        }
        return max;
    }

