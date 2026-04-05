import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int[][] map;
    public static long[][] dp;
    public static int[] dx = {1,0};
    public static int[] dy = {0,1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map=new int[n][n];
        dp=new long[n][n];
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(long[] arr:dp){
            Arrays.fill(arr,-1);
        }
        
        long answer = findAnswer(0,0);
        System.out.println(answer);   
    }

    public static long findAnswer(int xIndex, int yIndex){
        if(xIndex == n-1 && yIndex == n-1){
            return 1;
        }

        if(dp[xIndex][yIndex]!=-1){
            return dp[xIndex][yIndex];
        }

        dp[xIndex][yIndex]=0;
        for(int dir=0;dir<2;dir++){
            int nextX=xIndex+(dx[dir]*map[xIndex][yIndex]);
            int nextY=yIndex+(dy[dir]*map[xIndex][yIndex]);

            if(nextX<0||nextX>=n||nextY<0||nextY>=n){
                continue;
            }
            
            dp[xIndex][yIndex]+=findAnswer(nextX,nextY);
        }

        return dp[xIndex][yIndex];
    }
}