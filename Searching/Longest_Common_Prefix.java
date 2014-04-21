// Chester

// m: length of strs    n: length of shortest string in strs
// Brute force: worst case O(m*n)

// jump to check in a step of sqrt(n)
// 1. find the n in O(m)
// 2. step = (int) Math.sqrt((double)n)
// 3. check the char in position (n, n-step, n-step*2, ..., start) in O(m*sqrt(n)) -- worst case
// 4. then check char from 0 to longest possible position in O(m*k)
// k is the length of the output

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null) return null; // input strs=null, output null;
        int len = strs.length;
        if(len<=0) return ""; // input strs=[], output ""
        int strLen = strs[0].length();
        // the shorest length of the string in strs
        for(String str : strs) {
            if(strLen>str.length())
                strLen = str.length(); 
        }
        int step = (int) Math.sqrt((double)strLen); // calculate the step
        int pointer = strLen - 1;
	// record the whether chars in position pointer the same
        ArrayList<Boolean> mark = new ArrayList<Boolean>();
	// jump check every sqrt(n)   
	while(pointer>=0) {
            char[] charA0 = strs[0].toCharArray();
            char c0 = charA0[pointer];
            boolean tag = true;
            for(int i=1;i<len;++i) {
                char[] charA = strs[i].toCharArray();
                char cX = charA[pointer];
                if(c0!=cX) {
                    tag = false;
                    mark.add(false);
                    break;
                }
            }
            if(tag==true) mark.add(true);
            pointer -= step;
        }

        int count = 0;
        int alLen = mark.size();
        for(int i=alLen-1;i>=0;--i) {
            if(mark.get(i)==true) 
                ++count;
            else break;
        }

	// the possible longest position
        int p = pointer+step*(count+1); // p is the position of the first different char in jump check 
        if(p>strLen) p = strLen; // or p is the length of the shortest string in strs
        int curP = 0;
        while(curP<p) {
            char[] charA0 = strs[0].toCharArray();
            char c0 = charA0[curP];
            for(int i=1;i<len;++i) {
                char[] charA = strs[i].toCharArray();
                char cX = charA[curP];
                if(c0!=cX) {
                    if(curP==0) return ""; // input strs = ["a", "b"], output = ""
                    StringBuffer sb = new StringBuffer();
                    for(int j=0;j<=curP-1;++j) { // j<=curP-1
                        sb.append(charA0[j]);
                    }
                    return sb.toString();
                }
            }
            ++curP;
        }
        if(curP==0) return ""; // input strs = [""], output = ""
        char[] charA = strs[0].toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int j=0;j<=curP;++j) {
            sb.append(charA[j]);
        }
        return sb.toString();

        
        
        
    }
}
