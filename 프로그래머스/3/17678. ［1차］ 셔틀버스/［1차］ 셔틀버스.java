import java.util.*;

class Solution {
    // n : 셔틀 운행 횟수, t : 셔틀 운행 간격,  m: 최대 크루 수 timetable : 크루 대기열 도착시간
    // 콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각
    
    public int[] busTime;
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<timetable.length;i++){
            String[] time = timetable[i].split(":");
            pq.add(Integer.parseInt(time[0])*60+Integer.parseInt(time[1]));
        }
        int startTime = 9*60;
        int lastTime=0;
        int total=0;
        for(int i=0;i<n;i++){
            total=0;
            while(!pq.isEmpty()){
                int curr = pq.peek();
                if(curr<=startTime&&total<m){
                    pq.poll();
                    total++;
                }else{
                    break;
                }
                lastTime = curr-1;
            }
            startTime+=t;
        }
        
        if(total<m){
            lastTime=startTime-t;
        }
        
        String hour = String.format("%02d",lastTime/60);
        String minute = String.format("%02d",lastTime%60);
        
        return hour+":"+minute;
    }
}