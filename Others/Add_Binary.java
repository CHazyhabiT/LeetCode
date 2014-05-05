// Chester

// 1. need to pad the shorter string
// 2. BufferString.reverse()

public class Solution {
    public String addBinary(String a, String b) {
        if(a==null||b==null) return null;
        int diff = Math.abs(a.length()-b.length());
        StringBuffer newS = new StringBuffer();
        for(int i=0;i<diff;++i) {
            newS.append('0');
        }
        if(a.length()<b.length()) {
            newS.append(a);
            a = newS.toString();
        }else {
            newS.append(b);
            b = newS.toString();
        }

        
        char[] aAry = a.toCharArray();
        char[] bAry = b.toCharArray();
        int carry = 0;
        int len = aAry.length;
        StringBuffer result = new StringBuffer();
        for(int i=len-1;i>=0;--i) {
            int aInt = 0;
            int bInt = 0;
            if(aAry[i]=='1') aInt = 1;
            if(bAry[i]=='1') bInt = 1;
            int sum = aInt + bInt + carry;
            if(sum>=2) carry = 1;
            else carry = 0;
            if(sum==0||sum==2) result.append('0');
            else result.append('1');
        }
        if(carry==1) result.append('1');
        
        return result.reverse().toString();
 
    }
}
