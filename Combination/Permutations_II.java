import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length<=0) return result;
        ArrayList<Integer> tuple = new ArrayList<Integer>();
        tuple.add(num[0]);
        result.add(tuple);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        for(int i=1;i<num.length;++i) {
            hashSet.clear();
            ArrayList<ArrayList<Integer>> current = result;
            result = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> ele : current) {
                for(int j=0;j<=ele.size();++j) {
                    ArrayList<Integer> newEle = (ArrayList<Integer>) ele.clone();
                    newEle.add(j, num[i]);
                    if(!hashSet.contains(newEle)) {
                        result.add(newEle);
                        hashSet.add(newEle);
                    }
                }
            }
        }
        return result;
        
        
    }
}
