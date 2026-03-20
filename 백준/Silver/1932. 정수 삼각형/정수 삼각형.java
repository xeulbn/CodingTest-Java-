import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int[][] dp;
    public static int[][] map;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            Arrays.fill(dp[i], -1);
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<i;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int answer = findAnswer(1,0);
        
        System.out.println(answer);
        
    }

    public static int findAnswer(int depth, int index){
        if(depth==n){
            return map[depth][index];
        }
        
        if (dp[depth][index] != -1) {
            return dp[depth][index];
        }

        dp[depth][index] = map[depth][index]+Math.max(
            findAnswer(depth + 1, index),
            findAnswer(depth + 1, index + 1)
        );
        
        return dp[depth][index];
    }
}