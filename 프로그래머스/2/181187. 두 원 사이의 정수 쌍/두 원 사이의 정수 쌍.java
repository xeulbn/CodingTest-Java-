import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long zeroPoint=0;
        for(int x=1;x<=r2;x++){
            int y2=(int)Math.sqrt(Math.pow(r2,2)-Math.pow(x,2));
            int y1 = (int)Math.ceil(Math.sqrt(Math.pow(r1,2)-Math.pow(x,2)));
            
            answer+=y2-y1+1;
        }
        answer=answer*4;
        return answer;
    }
}