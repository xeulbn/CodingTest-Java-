import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] parentArr = s.split("");
        
        for(int i=0;i<parentArr.length;i++){
            if(isAllRight(parentArr)){
                answer++;
            }
            parentArr= rotation(parentArr);
        }
        return answer;
    }
    
    public boolean isAllRight(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String c : arr) {
            if (c.equals("(") || c.equals("{") || c.equals("[")) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                String top = stack.peek();
                if ((top.equals("(") && c.equals(")")) ||
                    (top.equals("{") && c.equals("}")) ||
                    (top.equals("[") && c.equals("]"))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    public String[] rotation(String[] arr) {
        String[] res = new String[arr.length];
        for (int i = 1; i < arr.length; i++) {
            res[i-1] = arr[i];
        }
        res[arr.length - 1] = arr[0];
        return res;
    }   
}