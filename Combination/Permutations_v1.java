// Chester

// Orignial: 1,2,3,4
// function:
// 1,..., then ... is a sub question
// 2,..., then ... is a sub question
// 3,..., then ... is a sub question
// 4,..., then ... is a sub question

// permute(int[] num, int pointer, ArrayList<ArrayList<.>> result)
// pointer = 0, 1 ... num.length-1 
// each time we choose a value in the num to fill into the current location (pointer),
// this could be viewed as the value exchange in num

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	// the condition of num.length==0 could be handled in the recursive funtion permute()
        permute(num, 0, result);
        return result;
            
    }
    
    // values (0 ~ pointer-1) in num have been added
    private void permute(int[] num, int pointer, ArrayList<ArrayList<Integer>> result) {
        int len = num.length;
        if(pointer==(len-1)) {
            ArrayList<Integer> ls = new ArrayList<Integer>();
            for(int ele : num) {
                ls.add(ele);
            }
            result.add(ls);
        }else {
            for(int i=pointer;i<len;++i) {
                exch(num, pointer, i);
                permute(num, pointer+1, result);
                exch(num, pointer, i);
            }
        }
    }
    
    private void exch(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
  }
    

}
