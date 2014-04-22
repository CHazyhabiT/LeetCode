// Chester

// Brute force: O(n^3)
// for any combination of 3 numbers from the int array, compute its sum
// in LeetCode, this will cause Time-Limit-Exceeded

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num.length<3) return Integer.MAX_VALUE;
        ArrayList<Integer> al = new ArrayList<Integer>();
        return threeSumClosest(num, target, al, 0, 3);

    }
    
    private int threeSumClosest(int[] num, int target, ArrayList<Integer> al, int pointer, int k) {
        if(k==0) {
            int sum = 0;
            for(int val : al) sum += val;
            return sum;
        }
        ArrayList<Integer> newAl = new ArrayList<Integer>(al);
        newAl.add(num[pointer]);
        int sum1 = threeSumClosest(num, target, newAl, pointer+1, k-1);
        if(num.length-pointer-1>=k) {
            int sum2 = threeSumClosest(num, target, al, pointer+1, k);
            int dif1 = Math.abs(sum1-target);
            int dif2 = Math.abs(sum2-target);
            return dif1<dif2 ? sum1 : sum2;
        }
        return sum1;
    }
    
}
