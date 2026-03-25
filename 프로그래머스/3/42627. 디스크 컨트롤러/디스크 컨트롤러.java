import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs,(a,b)->{
            return a[0]-b[0];
        });
        
        //우선 순위 : 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int time =0;
        int index= 0;
        int total=0; 
        int count = 0; //처리한 job cnt
        
        while(count<jobs.length){
            //현재 시간까지 요청 들어온거 전부 pq에 담기
            while(index < jobs.length && jobs[index][0]<=time){
                pq.add(jobs[index]);
                index++;
            }
            
            if(!pq.isEmpty()){
                int[] curr = pq.poll();
                int request = curr[0];
                int duration = curr[1];
                
                time+=duration;
                total+=(time-request);
                count+=1;
            }else{
                time=jobs[index][0];
            }   
        }
        
        return total/jobs.length;
    }
}