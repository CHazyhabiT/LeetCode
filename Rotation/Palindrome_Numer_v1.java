public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int count = 0;
        int temp = x;
        while(temp>=1) {
            temp /= 10;
            ++count;
        }
        temp = x;
        for(int i=0;i<count/2;++i) {
            int l = temp / (int)Math.pow(10, count-2*i-1);
            int r = temp % 10;
            if(l!=r) return false;
            temp = temp % (int)Math.pow(10, count-2*i-1);
            temp = temp / 10;
            
        }
        return true;
        
    }
}
