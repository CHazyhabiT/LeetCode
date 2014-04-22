// Chester

// adopt HashMap to achieve one pass
// O(N)

import java.util.HashMap;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        Arrays.fill(index, -1);
        if(numbers.length<=1) return index;
	// HashMap used to store the previous visited numbers and their index
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	// each time currently get a number (latter one), 
	// look up in the HashMap whether there is a satisfied number
        for(int i=0;i<numbers.length;++i) {
            int rest = target - numbers[i];
            if(hm.containsKey(rest)) {
                index[0] = hm.get(rest)+1;
                index[1] = i+1;
                return index;
            }
            hm.put(numbers[i], i); // this can guarrantte no duplicated index
        }
        return index;
   
    }
}
