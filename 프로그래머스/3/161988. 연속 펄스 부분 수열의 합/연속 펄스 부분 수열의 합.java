import java.util.*;

class Solution {
        
    public long solution(int[] sequence) {
        long answer=0;
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        
        dp1[0]=sequence[0];
        dp2[0] = (-1)*sequence[0];
        
        for(int i=1;i<sequence.length;i++){
            if(i%2==1){
                dp1[i]=Math.max(dp1[i-1]+sequence[i]*(-1),sequence[i]*(-1));
                dp2[i]=Math.max(dp2[i-1]+sequence[i],sequence[i]);
            }else{
                dp1[i]=Math.max(dp1[i-1]+sequence[i],sequence[i]);
                dp2[i]=Math.max(dp2[i-1]+sequence[i]*(-1),sequence[i]*(-1));
                
            }
        }
        
        Arrays.sort(dp1);
        Arrays.sort(dp2);
        
        answer = Math.max(dp1[sequence.length-1],dp2[sequence.length-1]);
        
        return answer;
    }
}