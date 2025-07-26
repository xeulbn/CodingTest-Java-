import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[] map;
    public static long[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        map=new int[n];
        dp=new long[n];
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            map[i]=Integer.parseInt(st.nextToken());
            dp[i]=Integer.MAX_VALUE;
        }

        dp[0]=0;

        for(int i=0;i<n;i++){
            if(dp[i]==Integer.MAX_VALUE){
                continue;
            }
            for(int j=1;j<=map[i];j++){
                if(i+j<n){
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                }
            }
        }

        if(dp[n-1]>=Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dp[n-1]);
        }

    }
}
