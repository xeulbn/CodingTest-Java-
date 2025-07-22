import java.io.*;
import java.util.*;

public class Main {

    public static int a;
    public static int k;
    public static int[] dp;


    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        a= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());

        dp=new int[k+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[a]=0;

        for(int i=a;i<k;i++){
            dp[i+1]=Math.min(dp[i+1],dp[i]+1);
            if(i*2>k){
                continue;
            }
            dp[i*2]=Math.min(dp[i*2],dp[i]+1);
        }
        System.out.println(dp[k]);


    }
}
