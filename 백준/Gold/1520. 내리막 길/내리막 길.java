import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int m;
    public static int[][] map;
    public static int[][] dp;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map=new int[n][m];
        dp = new int[n][m];
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());        
            }
        }

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        int answer = findAnswer(0,0);

        System.out.println(answer);
    }

    public static int findAnswer(int xIndex,int yIndex){
        if(xIndex==n-1&&yIndex==m-1){
            return 1;
        }

        if(dp[xIndex][yIndex] != -1){
            return dp[xIndex][yIndex];
        }

        dp[xIndex][yIndex]=0;
        
        for(int dir=0;dir<4;dir++){
            int nextX=xIndex+dx[dir];
            int nextY=yIndex+dy[dir];

            if(nextX<0||nextX>=n||nextY<0||nextY>=m){
                continue;
            }
            if(map[nextX][nextY] >= map[xIndex][yIndex]){
                continue;
            }
            
            dp[xIndex][yIndex] += findAnswer(nextX, nextY);
        }

        return dp[xIndex][yIndex];
    }
}