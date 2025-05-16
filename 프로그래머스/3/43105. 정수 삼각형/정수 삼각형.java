import java.util.*;

class Solution {
    public static int[][] dp;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        int n= triangle.length;
        int m=triangle[n-1].length;
        
        dp=new int[n][m];
        dp[0][0]=triangle[0][0];
        
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=0;
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if (j < i){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + triangle[i][j]);
                }
                    
                if (j - 1 >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + triangle[i][j]);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        return answer;

    }
}