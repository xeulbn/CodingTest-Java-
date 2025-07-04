import java.util.*;

class Solution {
    
    private static final int number=1234567;
    
    public int solution(int n) {
        int answer = 0;
        
        if(n==0||n==1){
            return n;
        }
        
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<n+1;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1234567;            
        }
        
        return dp[n];
    }
}