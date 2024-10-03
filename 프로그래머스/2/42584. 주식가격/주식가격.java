import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            Stack<Integer> priceStack = new Stack<>();

            for(int i=0;i<prices.length;i++){
                while(!priceStack.isEmpty() && prices[priceStack.peek()]>prices[i]){
                    answer[priceStack.peek()]=i-priceStack.peek();
                    priceStack.pop();
                }
                priceStack.push(i);
            }

            while(!priceStack.isEmpty()){
                answer[priceStack.peek()]=prices.length-priceStack.peek()-1;
                priceStack.pop();
            }

            return answer;

        }
    }