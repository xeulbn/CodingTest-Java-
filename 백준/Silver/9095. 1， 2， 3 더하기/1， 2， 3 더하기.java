import java.io.*;
import java.util.*;

public class Main {

    public static int t;
    public static int n;
    public static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t= Integer.parseInt(st.nextToken());
        dp=new int[12];

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        solution(11);

        for(int i=0;i<t;i++){
            st=new StringTokenizer((br.readLine()));
            n=Integer.parseInt(st.nextToken());
            System.out.println(dp[n]);
        }

    }

    public static int solution(int x){
        for(int i=4;i<=x;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[x];
    }
}
