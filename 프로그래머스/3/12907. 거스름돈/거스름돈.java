import java.util.*;

class Solution {
    public static final int MOD = 1000000007;
    
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for (int coin : money) {
            for (int i = coin; i<=n; i++) {
                dp[i] = (dp[i] + dp[i-coin]) % MOD;
            }
        }
        return dp[n];
    }
}