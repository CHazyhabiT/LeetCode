// Chester

// use Stack to store the previous
// one pass O(N), space maximum to O(N/2)
// test case
// [][]{}{()}
// [
// ]
import java.util.Stack;
public class Solution {
    public boolean isValid(String s) {
        if(s==null) return false;
        char[] pare = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c : pare) {
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            else {
                if(stack.empty()) { // test s with only end parenthese "[]]]"
                    return false;
                }else {
                    char pre = stack.pop();
                    switch(c){
                        case ')': if(pre!='(') return false;
                            break;
                        case '}': if(pre!='{') return false;
                            break;
                        case ']': if(pre!='[') return false;
                            break;
                        default : return false;
                    }
                }
            }
  
        }
        if(stack.empty()) return true; // test s with only start parenthese "[][["
        else return false;
        
        
    }
}
