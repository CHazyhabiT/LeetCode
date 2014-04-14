public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;
        generateMatrix(matrix, value, 0, 0, n, n);
        return matrix;
        
    }
    private void generateMatrix(int[][] matrix, int value, int mStart, int nStart, int mLen, int nLen) {
        if(mLen<=0||nLen<=0) return;
        int mEnd = mStart + mLen - 1;
        int nEnd = nStart + nLen - 1;
        for(int j=nStart;j<=nEnd;++j) {
            matrix[mStart][j] = value++;
        }
        if(mLen==1) return;
        for(int i=mStart+1;i<=mEnd;++i) {
            matrix[i][nEnd] = value++;
        }
        if(nLen==1) return;
        for(int j=nEnd-1;j>=nStart;--j) {
            matrix[mEnd][j] = value++;
        }
        for(int i=mEnd-1;i>=mStart+1;--i) {
            matrix[i][nStart] = value++;
        }
        generateMatrix(matrix, value, mStart+1, nStart+1, mLen-2, nLen-2);
        
        
        
    }
}
