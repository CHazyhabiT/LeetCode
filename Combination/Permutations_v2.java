// Chester

// DP
// add a number at a time from num[0] to num[n-1]

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length==0) return result;
        ArrayList<Integer> tuple = new ArrayList<Integer>();
        tuple.add(num[0]);
        result.add(tuple);
        for(int i=1;i<num.length;++i){
            int value = num[i];
            ArrayList<ArrayList<Integer>> current = result;
            result = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> ele : current){
                int length = ele.size();
                for(int j=0;j<=length;++j){
                    // clone returns a shallow copy of this ArrayList instance (Object)
                    ArrayList<Integer> temp = (ArrayList<Integer>) ele.clone();
                    // ArrayList.add(int index, E element) add element to a specific position
                    temp.add(j, value);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
