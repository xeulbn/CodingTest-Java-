import java.util.*;

class Solution {
    
    public int[][] dp;
    public boolean[][] isPuddle;
    public int MOD = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        
        dp=new int[n][m];
        isPuddle=new boolean[n][m];
        dp[0][0]=1;
        
        for (int[] puddle : puddles) {
            int x = puddle[0] - 1; 
            int y = puddle[1] - 1;
            isPuddle[y][x] = true;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isPuddle[i][j]){
                    dp[i][j]=0;
                    continue;
                }
                
                if(i==0&&j==0){
                    continue;
                }
                
                int fromUp =0;
                int fromLeft=0;
                
                if(i>0){
                    fromUp=dp[i-1][j];
                }
                
                if(j>0){
                    fromLeft=dp[i][j-1];
                }
                
                dp[i][j]=(fromUp+fromLeft)%MOD;
            }
        }
        
        return (dp[n-1][m-1])%MOD;
    }
}