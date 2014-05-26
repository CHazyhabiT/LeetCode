// Chester

// idea:
// two transaction happens in two distinct range
// so forward and backward traverse the array
// O(n) time and space

// example:
// stock:     4 2 3 8 7 1 4 3 9 5
// forward-- from 0 to len-1
// lowest:    4 2 2 2 2 1 1 1 1 1
// history:   0 0 1 6 6 6 6 6 8 8
// backward-- from len-1 to 0
// highest:   9 9 9 9 9 9 9 9 9 5
// future:    8 8 9 14 14 14 12 12 8 8


public class Solution {

    
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int len = prices.length;
        int[] historyPro = new int[len];
        historyPro[0] = 0;
        int lowest = prices[0];
        for(int i=1;i<len;++i) {
            lowest = Math.min(lowest, prices[i]);
            historyPro[i] = Math.max(historyPro[i-1], prices[i]-lowest);
        }
        int[] futurePro = new int[len];
        futurePro[len-1] = 0;
        int highest = prices[len-1];
        int maxPro = historyPro[len-1]+futurePro[len-1]; // test case: 1 2
        for(int i=len-2;i>=0;--i) {
            highest = Math.max(highest, prices[i]);
            futurePro[i] = Math.max(futurePro[i+1], highest-prices[i]);
            maxPro = Math.max(maxPro, historyPro[i]+futurePro[i]);
        }
        
        return maxPro;
 
    }
    
}
