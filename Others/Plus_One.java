import java.util.Arrays;
public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for(int i=length-1;i>=0;--i) {
            if(digits[i]==9) {
                digits[i] = 0;
            }else {
                digits[i] += 1;
                break;
                
            }
        }
        if(digits[0]==0){
            int[] result = new int[length+1];
            Arrays.fill(result, 0);
            result[0] = 1;
            return result;
        } else return digits;
        
    }
}
