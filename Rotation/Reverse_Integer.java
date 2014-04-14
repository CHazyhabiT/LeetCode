public class Solution {
    public int reverse(int x) {
        int reverse = 0;
        int rest = x;
        int mode;
        while(rest!=0){
            mode = rest % 10;
            reverse = reverse*10 + mode;
            rest = rest / 10;
        }
        return reverse;
        
    }
}
