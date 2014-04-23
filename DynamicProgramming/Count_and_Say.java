// Chester

// DP or could be decribed as BFS or level order

public class Solution {
    public String countAndSay(int n) {
        if(n<=0) return "";
        ArrayList<Character> current = new ArrayList<Character>();
        current.add('1');
        for(int i=2;i<=n;++i) {
            ArrayList<Character> parent = current;
            current = new ArrayList<Character>();
            int count = 1;
            char say = parent.get(0);
            for(int j=1;j<parent.size();++j) {
                if(say==parent.get(j)) {
                    ++count;
                }else {
                    addCountSay(current, count, say);
                    count = 1;
                    say = parent.get(j);
                }
            }
            addCountSay(current, count, say);
            
        }
        StringBuffer sb = new StringBuffer();
        for(char c: current) sb.append(c);
        return sb.toString();
        
    }
    
    private void addCountSay(ArrayList<Character> countSay, int count, char say) {
        String countS = Integer.toString(count); // int to String
        char[] countC = countS.toCharArray();
        for(char c : countC) {
            countSay.add(c);
        }
        countSay.add(say);
    }
    
    
}
