// Chester

// first sorting, in order to efficiently jump some unnecessary combinations,
// search the combinations from both end by implementing three pointer:
// midP: startfrom 1 to length-2
// leftP: start from 0 to midP-1
// rightP: start from length-1 to midP+1

// sorting O(nlogn) + at worst case O(n^2)
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num.length<3) return Integer.MAX_VALUE;
        Arrays.sort(num);
        int closeSum = num[0] + num[1] + num[2];
        int closeDiff = Math.abs(target-closeSum);
        for(int i=1;i<num.length-1;++i) {
            int lp = 0;
            int rp = num.length-1;
            int mark = 0;
            while(lp<i&&rp>i) {
                int tempSum = num[lp] + num[i] + num[rp];
                if(tempSum==target) return target;
                else if(tempSum<target) ++lp;
                else --rp;
                
                int tempDiff = Math.abs(target-tempSum); 
                if(tempDiff<closeDiff) {
                    closeSum = tempSum;
                    closeDiff = tempDiff;
                }
                
                if(tempSum<target) {
                    if(mark==0) mark = -1;
                    else if(mark==1) break;
                    
                }else {
                    if(mark==0) mark = 1;
                    else if(mark==-1) break;
                    
                }
                
                
            }
            
        }
        
        return closeSum;
        
        


    }
    
}
