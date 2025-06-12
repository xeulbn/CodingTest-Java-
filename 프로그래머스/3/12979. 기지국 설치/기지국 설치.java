import java.util.*;

class Solution {
    public static boolean[] visited;
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 1+2*w;
        int start=1;
        
        //누가 봐도 이분탐색인디...기준이 뭘까...
        for(int stationNo:stations){
            int left= stationNo-w;
            int right= stationNo+w;
            
            if(left>start){
                int gap= left-start;
                if((gap+coverage-w)%coverage>w+1){
                    answer=answer+(gap+coverage-w)/coverage+1;
                }else{
                    answer=answer+(gap+coverage-w)/coverage;
                }
            }
            start=right+1;
        }     
        
        if(start<=n){
            int gap=n-start+1;
            if((gap+coverage-w)%coverage>w+1){
                    answer=answer+(gap+coverage-w)/coverage+1;
            }else{
                answer=answer+(gap+coverage-w)/coverage;
            }
        }
        

        return answer;
    }
}