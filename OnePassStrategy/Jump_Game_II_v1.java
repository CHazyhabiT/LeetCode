// Chester

// DP
// the ith element must be jumped from the (0 ~ i-1) element
// worst case: O(n!)

public class Solution {
    public int jump(int[] A) {
        if(A.length<=1) return 0;
        int[] minJump = new int[A.length];
        Arrays.fill(minJump, 0);
        for(int i=0;i<A.length-1;++i) {
            int val = A[i];
            for(int j=1;j<=val;++j) {
                if(i+j<minJump.length) {
                    if(minJump[i+j]==0||minJump[i+j]>minJump[i]+1) 
                        minJump[i+j] = minJump[i] + 1;
                }
            }
        }
        return minJump[A.length-1];
    }
}
