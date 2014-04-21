// Chester

// DP
// O(m*n) time O(n) space

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null) return 0;
        int m = obstacleGrid.length;
        if(m<=0) return 0;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) return 0;
        int[] curRow = new int[n];
        Arrays.fill(curRow, 0); // fill curRow with 0s
        curRow[0] = 1;
        for(int i=0;i<m;++i) {
            if(obstacleGrid[i][0]==1) curRow[0] = 0;
            for(int j=1;j<n;++j) {
                if(obstacleGrid[i][j]==0)
                    curRow[j] += curRow[j-1];
                else curRow[j] = 0;
            }
            
            
        }
        return curRow[n-1];
        
        
    }
}
