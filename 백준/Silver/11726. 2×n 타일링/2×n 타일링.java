import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        
        int answer= findAnswer(n);
        
        System.out.println(answer);
        
    }

    public static int findAnswer(int x){
        if(x==1){
            return 1;
        }
        if(x==2){
            return 2;
        }
        
        int[] dp= new int[x+1];
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<x+1;i++){
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }
        return dp[x];
    }
}