public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length<=1){
            int[] index = {-1};
            return index;
        }
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<numbers.length;i++){
            if(hm.containsKey(numbers[i])){
                ArrayList<Integer> al = hm.get(numbers[i]);
                al.add(i);
                hm.put(numbers[i],al);
            }else{
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(i);
                hm.put(numbers[i],al);
            }
            
        }
        for(int i=0;i<numbers.length-1;i++){
            int rest = target - numbers[i];
            if(hm.containsKey(rest)){
                ArrayList<Integer> al = hm.get(rest);
                for(int j=0;j<al.size();j++){
                    if(i!=al.get(j)){
                        int[] result = new int[2];
                        result[0] = i+1;
                        result[1] = al.get(j)+1;
                        return result;
                    }
                }
            }
        }
        int[] result = {-1};
        return result;
       
        
    }
}
