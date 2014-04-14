import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		if(num.length<3){
		    return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(num);
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp;
		
		HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
		int rP, lP;
		for(int i=1;i<num.length-1;i++){
		    rP = 0;
		    lP = num.length-1;
		    int sum;
		    while(rP<i&&lP>i){
		        sum = num[rP] + num[i] + num[lP];
		        if(sum==0){
		            temp = new ArrayList<Integer>();
		            temp.add(num[rP]);
		            temp.add(num[i]);
		            temp.add(num[lP]);
		            if(!hs.contains(temp)){
		                result.add(temp);
		                hs.add(temp);
		            }
		            rP++;
		            lP--;
		        }else if(sum<0) rP++;
		        else lP--;
		            
	
		        
		        
		        
		    }
		    
		    
		    
		    
		}
		return result;

	}


}
