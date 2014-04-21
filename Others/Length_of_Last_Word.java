// Chester
// String.trim();
// String.toCharArray();

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null) return 0;
        s = s.trim(); // return a copy of the string s with leading and tailing whitespace omitted
        // s = "   "; all are whitespace
        // s = s.trim; 
        // then s = ""; s.length() = 0; s != null
        char[] charA = s.toCharArray();
        int count = 0;
        for(int i=charA.length-1;i>=0;--i) {
            
            if(charA[i]!=' ') 
                ++count;
            else break;
        }
        return count;
        
    }
}
