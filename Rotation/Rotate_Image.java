public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n/2;++i) {
            int start = i;
            int end = n - i - 1;
            for(int j=0;j<(end-start);++j) {
                int topLeft = matrix[start][start+j];
                // bottom left => top left
                matrix[start][start+j] = matrix[end-j][start];
                
                matrix[end-j][start] = matrix[end][end-j];
                
                matrix[end][end-j] = matrix[start+j][end];
                
                matrix[start+j][end] = topLeft;

            }
   
        }
        
    }
}
