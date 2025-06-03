import java.util.*;

class Solution {
    
    public static int[][] dp;
    public static int x=1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp= new int[m+1][n+1];
        
        for(int[] puddle: puddles){
            dp[puddle[0]][puddle[1]]=-1;
        }
        
        dp[1][1]=1;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(dp[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                
                if(dp[i-1][j]>0){
                    dp[i][j]+=dp[i-1][j]%x;
                    
                }
                if(dp[i][j-1]>0){
                    dp[i][j]+=dp[i][j-1]%x;
                }
                dp[i][j]=dp[i][j]%x;
            }
        }
        
        answer=dp[m][n];
        return answer;
    }
}