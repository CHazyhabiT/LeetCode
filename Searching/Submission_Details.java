// Chester

// O(n) time and space
// test cases:
// [4, 6] [7, 9]; [1, 3]
// [4, 6] [7, 9]; [10, 11]
// [1, 2] [3, 5] [6, 7] [8, 10] [12, 16]; [4, 9]
// [1, 3] [6, 7] [9, 12] [15, 20]; [4, 13]
// [1, 2] [4, 5]; [3, 3]
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals.size()==0) {
            result.add(newInterval);
            return result;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        Interval current = null;
        boolean flag = false; // mark whether newInterval has been dealt with
        for(Interval interval : intervals) {
            if(current==null) {
                current = new Interval(interval.start, interval.end);
            } else {
                if(current.end<interval.start) {
                    result.add(current);
                    current = new Interval(interval.start, interval.end);
                } else {
                    current = merge(current, interval);
                    continue;
                    
                }
            }
	    // compare current to newInterval
            if(flag==false) { // if not processed, then compare
                if(current.start>end) {
                    result.add(newInterval);
                    result.add(current);
                    flag = true;
                    current = null;
                } else if(current.end<start) {
                    result.add(current);
                    current = null;
                } else {
                    current = merge(current, newInterval);
                    flag = true;
                }
            } else { // if already processed, add the rest intervals directly
                result.add(current);
                current = null;
                
            }
  
        }
        if(current!=null) result.add(current);
        if(flag==false) result.add(newInterval); // in case the newIntervals has not been processed
        return result;
        
    }
    
    private Interval merge(Interval inter1, Interval inter2) {
        if(inter1.end<inter2.start) return null;
        int start = Math.min(inter1.start, inter2.start);
        int end = Math.max(inter1.end, inter2.end);
        return new Interval(start, end);
    }
    
}
