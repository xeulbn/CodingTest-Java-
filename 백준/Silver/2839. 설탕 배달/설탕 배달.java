import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int answer= findMinimum(n);
        System.out.println(answer);
    }

    public static int findMinimum(int n){
        int[] dp = new int[n+1];
        if(n>=3)
            dp[3]=1;
        if(n>=5)
            dp[5]=1;
        
        for(int i=6;i<=n;i++){
            if(i%5==0){
                dp[i]=dp[i-5]+1;
            }else if(i%3==0){
                dp[i]=dp[i-3]+1;
            }else{
                if(dp[i-3]!=0 && dp[i-5]!=0){
                    dp[i]=Math.min(dp[i-3],dp[i-5])+1;
                }
            }
        }

        if(dp[n]==0){
            return -1;
        }
        return dp[n];
    }

}