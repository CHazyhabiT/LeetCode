// Chester

// values of all the nodes are different
// result[i] i ranges from [0, 1, ..., n]
// 	-- represent the number of unique BST in size i

public class Solution {
    public int numTrees(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        for(int i=1;i<=n;++i) { // i represent the root
            for(int j=0;j<i;++j) { // j represent the size of tree
                result[i] += result[j]*result[i-j-1];
            }
        }
        return result[n];
        
    }
}

