import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer=0;
        PriorityQueue<Integer> pqA= new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> pqB= new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<A.length;i++){
            pqA.offer(A[i]);
        }
        for(int i=0;i<B.length;i++){
            pqB.offer(B[i]);
        }
                
        
        while(!pqA.isEmpty() && !pqB.isEmpty()){
            int nowA=pqA.poll();
            int nowB=pqB.peek();
            
            if (nowB > nowA) {
                answer++;
                pqB.poll(); 
            } 
        }
        
        return answer;
    }
}