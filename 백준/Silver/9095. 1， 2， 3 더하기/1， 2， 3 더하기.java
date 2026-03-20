import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int t;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        t=Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++){
            st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int answer = dp(n);
            System.out.println(answer);
        }
    }

    public static int dp(int x){
        int[] dp = new int[x+1];
        if(x==0||x==1){
            return 1;
        }
        if(x==2){
            return 2;
        }

        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3;i<x+1;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[x];
    }
}