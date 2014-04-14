public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int h = m - 1;
        int l = 0;
        while(l<=h) {
            int medM = (h + l)/2;
            if(matrix[medM][0]==target) return true;
            if(matrix[medM][0]>target) {
                h = medM-1;
            }else {
                if(matrix[medM][n-1]==target) return true;
                if(matrix[medM][n-1]<target) {
                    l = medM + 1;
                }else {
                    h = n - 1;
                    l = 0;
                    while(l<=h) {
                        int medN = (h + l)/2;
                        if(matrix[medM][medN]==target) return true;
                        if(matrix[medM][medN]<target) l = medN + 1;
                        else h = medN - 1;
                        
                    }
                    return false;
                }
            }
        }
        
        return false;
 
    }
}
