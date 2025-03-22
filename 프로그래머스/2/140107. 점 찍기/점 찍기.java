import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long cnt = 0;
        
        long maxY=0;
        for(long x=0;x<=d;x+=k){
            maxY = (long) Math.sqrt(Math.pow(d,2)-Math.pow(x,2));
            cnt+=(maxY/k)+1;
        }
               
        return cnt;
    }
}