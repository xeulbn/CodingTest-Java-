import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty() && prices[stack.peek()]>prices[i]){
                int prevIndex = stack.pop();
                answer[prevIndex] = i-prevIndex;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }
        
        return answer;
        
    }
}