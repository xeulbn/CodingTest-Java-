import java.util.*;

class Solution{
    
    private static int [][]dp;
    
    public int solution(int [][]board){
        
        int row = board.length;
        int col = board[0].length;
        dp = new int[row][col];
        
        int maxLength = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j]==0){
                    continue;
                }
                
                if(i==0||j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],
                                        Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
                
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        
        return maxLength * maxLength;
    }
    
}