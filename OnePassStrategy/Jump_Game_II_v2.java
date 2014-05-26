// Chester

// since we jump from left to right
// the min jump number of the ith element must >= one of the previous elment
 
// less than O(n)
public class Solution {
    public int jump(int[] A) {
        if(A.length<=1) return 0;
        int[] minJump = new int[A.length];
        Arrays.fill(minJump, 0);
        int longest = 0; // used to avoid jumping to the element which was already being jumped at
        for(int i=0;i<A.length-1;++i) {
            int val = A[i];
            for(int j=val;j>=longest-i+1;--j) { // first to jump to the farest element
                if(i+j<minJump.length) {
                    if(i+j==A.length-1) {
                        minJump[A.length-1] = minJump[i] + 1;
                        return minJump[A.length-1];
                    }
                    if(minJump[i+j]==0) 
                        minJump[i+j] = minJump[i] + 1;
                }
            }
            if(longest<i+val) longest = i+val;
        }
        return 0;
    }
}
