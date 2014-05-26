// Chester

// Brute force: O(n^2)
// However, it could be O(n)
// 1. first get the difference array between tha gas and cost
// 2. check whether such a solution exist
// 3. maintain a start and end pointer indicating the path direction

// to guarantee the solution to be unique
// the condition (the sum of the difference array is 0) is its necessary condition
// as for whether it is sufficient, still need more research
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length<=0||gas.length!=cost.length) return -1;
        int len = gas.length;
        int[] diff = new int[len];
        for(int i=0;i<len;++i)
            diff[i] = gas[i] - cost[i];
	// check whether such a solution exist
        int sum = 0;
        for(int ele : diff)
            sum += ele;
        if(sum<0) return -1;
        
        int start = 0;
        int end = 0;
        int rest = 0;
        while(end<len) {
	    // if previous left gas + currently left gas >= 0, we can move forward
            if(rest+diff[end]>=0) {
                rest += diff[end];
                ++end;
	    // otherwise, we have backward our start point
            }else {
                start = (start-1+len)%len;
                rest += diff[start];
            }
	    // the terminal condition
            if((end+1)%len==start) break;
        }
        return start;
    }
    
}

