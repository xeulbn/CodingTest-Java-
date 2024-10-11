import java.util.Stack;

class Solution {
        public int solution(int[] order) {
            int answer = 0;
            int []priority = new int[order.length];

            for(int i=0;i<order.length;i++){
                priority[order[i]-1]=i;
            }

            Stack<Integer> stack = new Stack<>();


            for(int i=0;i<priority.length;i++){
                if(priority[i]==0){
                    answer++;
                }else{
                    stack.push(priority[i]);
                }

                while(!stack.isEmpty()&&stack.peek()==answer){
                    stack.pop();
                    answer++;
                }

            }
            return answer;
        }
    }