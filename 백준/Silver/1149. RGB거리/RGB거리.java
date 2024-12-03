import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] arr;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n+1][3];

        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=Integer.parseInt(st.nextToken());
        }

        dp=new int[n+1][3];
        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];

        for(int i=1;i<n+1;i++){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+arr[i][2];
        }

        System.out.println(Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2])));



    }
}
