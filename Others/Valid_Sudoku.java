// Chester

// 3*O(m*n)
// note that there might not be a solution for a valid Sudoku
// to test whether a Sudoku problem is valid, 
// just to test three rules (rows, colums, 3*3grids)
// whether there is a solution exist in a valid Sudoku,
// it is not the problem we need to solve here

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = 0;
        if(m<=0) return false;
        else n = board[0].length;
        if(!(m==n&&m%3==0)) return false;
        
        HashSet<Character> hs = new HashSet<Character>();
        // test rows
        for(int i=0;i<m;++i) {
            hs.clear();
            for(char c : board[i]) {
                boolean isVS = checkDup(hs, c);
                if(isVS==false) return false;
            }
        }
        
        // test columns
        for(int j=0;j<n;++j) {
            hs.clear();
            for(int i=0;i<m;++i) {
                boolean isVS = checkDup(hs, board[i][j]);
                if(isVS==false) return false;
            }
            
        }
        
        // test 9 grids
        for(int i=0;i<m;i+=3) {
            for(int j=0;j<n;j+=3) {
                boolean isVS = testGrid(board, i, j, hs);
                if(isVS==false) return false;
            }
        }
        return true;
        
        
    }
    
    private boolean testGrid(char[][] board, int m, int n, HashSet<Character> hs) {
        hs.clear();
        for(int i=m;i<m+3;++i) {
            for(int j=n;j<n+3;++j) {
                boolean isVS = checkDup(hs, board[i][j]);
                if(isVS==false) return false;
            }
        }
        return true;
    }
    
    private boolean checkDup(HashSet<Character> hs, char c) {
        if(c=='.') return true;
        if(hs.contains(c)) return false;
        else {
            hs.add(c);
            return true;
        }
    }
    
    
}
