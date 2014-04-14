public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] minRow = new int[n];
        minRow[0] = grid[0][0];
        for(int i=1;i<n;++i){
            minRow[i] = minRow[i-1] + grid[0][i];
        }
        for(int i=1;i<m;++i){
            minRow[0] += grid[i][0];
            for(int j=1;j<n;++j){
                int min = Math.min(minRow[j], minRow[j-1]);
                minRow[j] = min + grid[i][j];
            }
        }
        return minRow[n-1];
    }
}
