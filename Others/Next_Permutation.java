// Chester

// test case:
// 1 2 3
// 1 3 2
// 3 2 1
// 1 1 5
// 1 2 3 5 5 5

// start from right-end to left-end
// first make an assumption that no duplicates
// then from right to left, the elements either in
// increase order or in decrease order

public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length<=1) return;
        int decreaseInd = num.length-2;
	// find the index of the element start to decrease (from right to left)
        while(decreaseInd>=0&&num[decreaseInd]>=num[decreaseInd+1]) {
            --decreaseInd;
        }
        if(decreaseInd==-1) {
            reverse(num, 0, num.length-1);
            return;
        }
        int nextStartInd = num.length-1;
	// find the index of the element should be the start of the next permutation
        while(nextStartInd>decreaseInd&&num[decreaseInd]>=num[nextStartInd]) {
            --nextStartInd;
        }
        exch(num, decreaseInd, nextStartInd);
	// re-order the elements behind the decreaseInd
	// since the 
        reverse(num, decreaseInd+1, num.length-1);

        
    }
    
    private void exch(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    private void reverse(int[] num, int start, int end) {
        for(int i=0;i<(end-start+1)/2;++i) {
            exch(num, start+i, end-i);
        }
    }

}
