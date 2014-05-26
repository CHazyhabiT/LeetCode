public class Solution {
    public String convert(String s, int nRows) {
        if(s==null||nRows<=1) return s;
        ArrayList<ArrayList<Character>> rows = new ArrayList<ArrayList<Character>>(nRows);
        for(int i=0;i<nRows;++i) 
            rows.add(new ArrayList<Character>());
        
        int current = 0;
        boolean isDown = true;
        for(int i=0;i<s.length();++i) {
            rows.get(current).add(s.charAt(i));
            if(current==0){
                ++current;
                isDown = true;
            }
            else if(current==nRows-1){
                --current;
                isDown = false;
            }
            else {
                if(isDown) ++current;
                else --current;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(ArrayList<Character> row : rows) {
            for(char c: row) sb.append(c);
        }
        
        return sb.toString();
        
    }
}
