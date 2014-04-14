public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows<1) return result;
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        int rowCount = 2;
        result.add(row1);
        while(rowCount<=numRows){
            ArrayList<Integer> row = genNextRow(result.get(rowCount-2));
            result.add(row);
            
            
            ++rowCount;
        }
        
        return result;
        
    }
    
    private ArrayList<Integer> genNextRow(ArrayList<Integer> row){
        int len = row.size();
        ArrayList<Integer> nextRow = new ArrayList<Integer>();
        nextRow.add(row.get(0));
        for(int i=0;i<len-1;++i){
            nextRow.add(row.get(i)+row.get(i+1));
        }
        nextRow.add(row.get(len-1));
        
        return nextRow;
        
        
        
    }
    
    
}
