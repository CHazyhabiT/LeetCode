public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int count = 0;
        int y = 0;
        int temp = x;
        while(temp>=1) {
            y = y * 10 + temp % 10;
            temp /= 10;
            
        }
        if(x==y) return true;
        else return false;
    }
}
