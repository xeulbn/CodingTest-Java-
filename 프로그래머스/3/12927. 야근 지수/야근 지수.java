import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<works.length;i++){
            pq.offer(works[i]);
        }
        
        while(n>0){
            int now=pq.poll();
            if(now==0){
                break;
            }
            now-=1;
            pq.offer(now);
            n-=1;
        }
        
        while(!pq.isEmpty()){
            answer+=Math.pow(pq.poll(),2);
        }
        
        return answer;
    }
}