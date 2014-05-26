// Chester

// 1. total gas is greater or equal than total cost, then round trip is possible
// 2. start with ith gas station, then to kth gas station, if it fails at the kth station
// 	then it is not possible to choose start between [i, k]
// 3. at that time we choose at the k+1 station as the start station

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length<=0||gas.length!=cost.length) return -1;
        int len = gas.length;
        int start = 0;
        int tank = 0;
        int total = 0;
        for(int i=0;i<len;++i) {
            tank += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(tank<0) {
                start = i+1;
                tank = 0;
            }
        }
        if(total<0) return -1;
        return start;
    }
    
}
