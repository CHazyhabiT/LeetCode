import java.util.HashMap;
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hm = romanValue();
        char[] charA = s.toCharArray();
        int result = 0;
        for(int i=0;i<charA.length;++i){
            int val1 = hm.get(charA[i]);
            int val2 = 0;
            if(i+1<charA.length) val2 = hm.get(charA[i+1]);
            if(val1<val2) result -= val1;
            else result += val1;
            
        }
        return result;
        
        
    }
    
    private HashMap<Character, Integer> romanValue(){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        return hm;
    }
    
    
    
}
