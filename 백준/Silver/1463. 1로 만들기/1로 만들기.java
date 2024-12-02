import java.io.*;
import java.util.*;;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        n=sc.nextInt();
        dp=new int[n+1];

        dp[1]=0;
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+1;
            if(i%2==0&&dp[i]>dp[i/2]+1){
                dp[i]=dp[i/2]+1;
            }
            if(i%3==0&&dp[i]>dp[i/3]+1){
                dp[i]=dp[i/3]+1;
            }
        }
        System.out.println(dp[n]);

    }

}
