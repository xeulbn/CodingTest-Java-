import java.util.*;

class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int answer = 0;

            long sum1=queueSum(queue1);
            long sum2=queueSum(queue2);

            Queue<Integer> realQueue1 = new LinkedList<>();
            Queue<Integer> realQueue2 = new LinkedList<>();
            for(int i=0;i<queue1.length;i++) {
                realQueue1.add(queue1[i]);
                realQueue2.add(queue2[i]);
            }

            while(sum1!=sum2){
                if(answer>(queue1.length+queue2.length)*2){
                    return -1;
                }

                int val=0;
                if(sum1<sum2){
                    val=realQueue2.poll();
                    realQueue1.add(val);
                    sum1+=(long) val;
                    sum2-=(long) val;
                }else if(sum1>sum2){
                    val=realQueue1.poll();
                    realQueue2.add(val);
                    sum1-=(long) val;
                    sum2+=(long) val;
                }
                else{
                    return answer;
                }
                answer++;
            }
            return answer;
        }


        public long queueSum(int[] queue){
            long sum=0;
            for(int i=0;i<queue.length;i++){
                sum+=(long)queue[i];
            }

            return sum;
        }
    }