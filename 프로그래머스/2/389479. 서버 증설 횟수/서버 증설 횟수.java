import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int nowServerCnt=0;
        int[] timeServer=new int[24];
        
        for(int i=0;i<players.length;i++){
            int timeIndex=i;
            
            //5시간 지난 서버 다운시키기
            if(timeIndex>=k&&timeServer[timeIndex-k]!=0){
                nowServerCnt = nowServerCnt-timeServer[timeIndex-k];
                
            }
            
            //서버 증설 판단하고 증설시키기
            if(players[i]>m*nowServerCnt){

                int increaseServerCnt= players[i]/m-nowServerCnt;
                timeServer[timeIndex]=increaseServerCnt;
                
                nowServerCnt=nowServerCnt+increaseServerCnt;
                answer+=increaseServerCnt;
            }
        }
        
        return answer;
    }
}