public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if(m==0) return result;
        int n = matrix[0].length;
        spiralOrder(matrix, result, 0, 0, m, n);
        return result;
    }
    
    private void spiralOrder(int[][] matrix, ArrayList<Integer> result, int mStart, int nStart, int lenM, int lenN) {
        if(lenM<=0||lenN<=0) return;
        int mEnd = mStart + lenM -1;
        int nEnd = nStart + lenN -1;
        for(int j=nStart;j<=nEnd;++j) {
            result.add(matrix[mStart][j]);
        }
        if(lenM==1) return;
        for(int i=mStart+1;i<=mEnd;++i) {
            result.add(matrix[i][nEnd]);
        }
        if(lenN==1) return;
        for(int j=nEnd-1;j>=nStart;--j) {
            result.add(matrix[mEnd][j]);
        }
        for(int i=mEnd-1;i>=mStart+1;--i) {
            result.add(matrix[i][nStart]);
        }
        spiralOrder(matrix, result, mStart+1, nStart+1, lenM-2, lenN-2);
        
        
        
        
    }
}
