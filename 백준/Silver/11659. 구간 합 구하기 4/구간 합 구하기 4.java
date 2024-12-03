import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int[] dp;
    public static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n+1];

        dp[0] = 0;

        st=new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            dp[i]=dp[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int j=1;j<=m;j++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            sb.append(dp[y]-dp[x-1]).append("\n");
        }

        System.out.println(sb);

    }
}
