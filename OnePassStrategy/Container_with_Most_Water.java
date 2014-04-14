public class Solution {
    public int maxArea(int[] height) {
        if(height.length<=1) return -1;
        int len = height.length;
        int l = 0;
        int r = len - 1;
        int max = 0;
        while(l<r) {
            int h = Math.min(height[l], height[r]);
            max = Math.max(max, (r-l)*h);
            if(height[l]<height[r]) ++l;
            else --r;
   
        }
        return max;
        
        
    }
}
