/**
 * the general way is to firstly generate the permutaion in a specific order
 * and then return the kth permutation
 * however, we can research on the relations betwen k and the permuation.
 */

public class Solution {
    public String getPermutation(int n, int k) {
        if(n<=0) return null;
        StringBuffer result = new StringBuffer();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        int divisor = 1;
        for(int i=1;i<n;++i) {
            divisor *= i;
            nums.add(i+1);
        }
        for(int i=0;i<n-1;++i) {
            int index;
            if(k==0) index = 0;
            else index = (k-1) / divisor; // important
            k -= index*divisor;  // important
            divisor /= (n-1-i);
            result.append(nums.get(index));
            nums.remove(index);
            
        }
        result.append(nums.get(0));
        return result.toString();
        
    }
}
