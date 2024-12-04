import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int[] dp;
    public static int[] arr;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();

        dp=new int[n+1];
        arr=new int[n+1];

        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+1;
            arr[i]=i-1;
            if(i%2==0&&dp[i]>dp[i/2]+1){
                dp[i]=dp[i/2]+1;
                arr[i]=i/2;
            }
            if(i%3==0&&dp[i]>dp[i/3]+1){
                dp[i]=dp[i/3]+1;
                arr[i]=i/3;
            }
        }

        System.out.println(dp[n]);

        sb=new StringBuilder();
        while(n>0){
            sb.append(n+" ");
            n=arr[n];
        }
        System.out.println(sb);


    }
}
