public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<1) return -1;
        if(n<1) return -1;
        int[] row = new int[n];
        for(int i=0;i<n;++i) {
            row[i] = 1;
        }
        for(int i=1;i<m;++i) {
            for(int j=1;j<n;++j) {
                row[j] += row[j-1];
            }
 
        }
        return row[n-1];
 
    }
}
