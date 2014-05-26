// Chester

// Lema
// max profit of two transactions happens
// 1. max profit of one transaction of the whole array + max profit of one transaction of the rest array
// 2. or twice transactions both happens in the range that get the max profit of one transaction of the whole array

// the transaction could be at most twice
// 1. get the max profit with one transaction to the full array, 
// 	record the start and end position (max, s, e)
// 2. the maximum profit in 2 transactions could happen in the following two situations
// 	a. result of one transaction from step 1 + another transaction in the rest arrays
// 	   [0, s-1] or [e+1, prices.length-1]
//	b. two transactions might happend in the array [s, e]

// O(n) time (4 times of one pass)
// O(1) space

// test cases:
// 8 11 13 6 13 8 15
// 1 7 2 6

public class Solution {
    
    class Wrapper {
        int max;
        int start, end;
        Wrapper(int maxProfit, int s, int e) {
            max = maxProfit;
            start = s;
            end = e;
        }
    }
    
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
	// get the max profit of one transaction in the whole array
        Wrapper maxOneTime = maxProfit(prices, 0, prices.length-1);
	// get the max profit of one transaction in the left array
        Wrapper maxSecondL = maxProfit(prices, 0, maxOneTime.start-1);
	// get the max profit of one transaction in the right array
        Wrapper maxSecondR = maxProfit(prices, maxOneTime.end+1, prices.length-1);
	// get the max profit of two transactions happens in [s, e]
        int maxTwice = maxProfitTwice(prices, maxOneTime.start, maxOneTime.end);

        int maxSecond = Math.max(maxSecondL.max, maxSecondR.max);
        int max = maxOneTime.max + maxSecond;
        return Math.max(max, maxTwice);
    }
    
    // given a range, return the max profit of one transaction
    private Wrapper maxProfit(int[] prices, int s, int e) {
        Wrapper result = new Wrapper(0, s, e);
        if(s<0||e>=prices.length||s>=e) return result;
        int curMax = 0;
        int curMaxS = s, curMaxE = e;
        int lowest = prices[s];
        for(int i=s+1;i<=e;++i) {
            if(prices[i]>lowest) {
                int profit = prices[i] - lowest;
                if(profit>curMax) {
                    curMax = profit;
                    curMaxE = i;
                }
            } else {
                lowest = prices[i];
                curMax = 0;
                curMaxS = i;
                curMaxE = i;
            }
            if(curMax>result.max) {
                result.max = curMax;
                result.start = curMaxS;
                result.end = curMaxE;
            }
        }
        return result;
        
    }
    
    // given a range, where
    // prices[s] is the smallest value
    // prices[e] is the largest value
    // find the max profit of two transaction
    private int maxProfitTwice(int[] prices, int s, int e) {
        int max = 0;
        int lowest = prices[e];
        for(int i=e-1;i>=s;--i) {
            if(prices[i]>lowest) {
                int pro = prices[i] - lowest;
                max = Math.max(pro, max);
            } else {
                lowest = prices[i];
            }
        }
        return prices[e] - prices[s] + max;
        
        
    }
    
}
