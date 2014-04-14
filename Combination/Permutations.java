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
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    int k=0;
                    while(k<j){
                        temp.add(ele.get(k));
                        k++;
                    }
                    temp.add(value);
                    while(k<length){
                        temp.add(ele.get(k));
                        k++;
                    }
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
