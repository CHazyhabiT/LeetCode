public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(rowIndex<0) return al;
        if(rowIndex==0) {
            al.add(1);
            return al;
        }
        for(int i=1;i<=rowIndex;++i) {
            ArrayList<Integer> temp = al;
            al = new ArrayList<Integer>();
            int len = temp.size();
            al.add(1);
            if(len>=2) {
                for(int j=0;j<len-1;++j) {
                    al.add(temp.get(j)+temp.get(j+1));
                }
            }
            al.add(1);
            
        }
        return al;
        
        
    }
}
