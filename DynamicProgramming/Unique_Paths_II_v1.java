// Chester

// DP
// O(m*n) time and space
// could be optimized in space

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null) return 0;
        int m = obstacleGrid.length;
        if(m<=0) return 0;
        int n = obstacleGrid[0].length;
        int[][] unique = new int[m][n];
        if(obstacleGrid[0][0]==1) return 0;
        else unique[0][0] = 1;
        // the first row
        for(int j=1;j<n;++j) {
            if(obstacleGrid[0][j]==0)
                unique[0][j] = unique[0][j-1];
            else unique[0][j] = 0;
        }
        // the first column
        for(int i=1;i<m;++i) {
            if(obstacleGrid[i][0]==0)
                unique[i][0] = unique[i-1][0];
            else unique[i][0] = 0;
        }
        
        for(int i=1;i<m;++i) {
            for(int j=1;j<n;++j) {
                if(obstacleGrid[i][j]==0)
                    unique[i][j] = unique[i-1][j] + unique[i][j-1];
                else unique[i][j] = 0;
            }
        }
        
        return unique[m-1][n-1];
        
    }
}
