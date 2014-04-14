public class Solution {
    public void sortColors(int[] A) {
        int[] count = {0, 0, 0};
        for(int color : A){
            if(color==0) ++count[color];
            else if(color==1) ++count[color];
            else ++count[color];
        }
        int i = 0;
        int colorT = 0;
        for(int c : count){
            for(int j=0;j<c;++j){
                A[i] =  colorT;
                ++i;
            }
            ++colorT;
        }
    }
}
