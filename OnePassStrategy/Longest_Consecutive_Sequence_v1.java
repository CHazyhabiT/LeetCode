// Chester

// optimal way: the Radix Sort takes O(n) time, and then scan the array to get the longest length
// 1. use HashSet to store all number
// 2. scan the array, for each number find the longest consecutive numbers it can get
// 3. remove the numbers from HashSet to avoid redundant searching
// O(n)

// the time to insert elements into hash
// depends on the rehashing process
// if you can specify the expected size of the full hashmap, then the expected runtime is O(1)


import java.util.HashSet;
public class Solution {
    public int longestConsecutive(int[] num) {
        if(num==null||num.length==0) return 0;
        HashSet<Integer> hs = new HashSet<Integer>(num.length * 2);
        int max = 1;
        for(int n : num) {  // O(n)
            hs.add(n);
        }
        
        for(int n : num) {
            
            int count = 1;
            int i = 0;
            hs.remove(n);
	    // if n = Integer.MAX_VALUE or Integer.MIN_VALUE
	    // then n +/- i will overflow
            while(hs.contains(n - ++i)) {
                ++count;
                hs.remove(n-i);
            }
            i = 0;
            while(hs.contains(n + ++i)) {
                ++count;
                hs.remove(n+i);
            }
            
            max = Math.max(max, count);
 
        }
        return max;
        
    }
}
