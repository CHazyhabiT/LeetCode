// Chester

// DP; level order traversal; BFS


import java.util.HashMap;
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits==null) return result;
        char[] digitsAry = digits.toCharArray();
        ArrayList<StringBuffer> parent = new ArrayList<StringBuffer>();
        parent.add(new StringBuffer());
        HashMap<Character, char[]> dict = new Dictionary().dict;
        for(char digit : digitsAry) {
            if(digit=='0'||digit=='1') continue;
            ArrayList<StringBuffer> current = parent;
            parent = new ArrayList<StringBuffer>();
            char[] list = dict.get(digit);
            for(StringBuffer sb : current) {
                for(char c : list) {
                    StringBuffer newSb = new StringBuffer(sb);
                    newSb.append(c);
                    parent.add(newSb);
                }
            }
        }
        for(StringBuffer sb : parent)
            result.add(sb.toString());
        return result;
    }
    
    class Dictionary {
        HashMap<Character, char[]> dict;
        Dictionary() {
            dict = new HashMap<Character, char[]>();
            char[] char2 = {'a', 'b', 'c'};
            char[] char3 = {'d', 'e', 'f'};
            char[] char4 = {'g', 'h', 'i'};
            char[] char5 = {'j', 'k', 'l'};
            char[] char6 = {'m', 'n', 'o'};
            char[] char7 = {'p', 'q', 'r', 's'};
            char[] char8 = {'t', 'u', 'v'};
            char[] char9 = {'w', 'x', 'y', 'z'};
            dict.put('2', char2 );
            dict.put('3', char3 );
            dict.put('4', char4 );
            dict.put('5', char5 );
            dict.put('6', char6 );
            dict.put('7', char7 );
            dict.put('8', char8 );
            dict.put('9', char9 );
        }
        
        
    }
    
}
