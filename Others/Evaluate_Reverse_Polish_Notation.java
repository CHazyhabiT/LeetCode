// Chester

import java.util.Stack;
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = Integer.parseInt(tokens[0]);
        for(String s : tokens) {
            if(isOperator(s)) {
                int int2 = stack.pop();
                int int1 = stack.pop();
                switch(s) {
                    case "+" : result = int1 + int2;
                        break;
                    case "-" : result = int1 - int2;
                        break;
                    case "*" : result = int1 * int2;
                        break;
                    case "/" : result = int1 / int2;
                        break;
                    default : break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        
        return result;
        
    }
    
    private boolean isOperator(String s) {
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/"))
            return true;
        else return false;
	// another way
	// String operators = "+-*/";
	// if(operators.contains(s)
	// 	return true;
	// else return false;
    }
}
