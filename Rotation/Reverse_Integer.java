// Chester

// test case:
// 123
// -123
// 10, 100: ask interviewer how to deal with this case
// the reverse integer might overflow, assume the input is a 32-bit integer, 
// then the reverse of 1000000003 overflows

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
