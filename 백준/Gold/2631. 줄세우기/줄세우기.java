import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        arr= new int[n];
        dp= new int[n];

        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            arr[i]= Integer.parseInt(st.nextToken());
        }

        dp[0]=1;
        int answer=0;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
                answer = Math.max(answer,dp[i]);
            }
        }
        System.out.println(n-answer);

    }
}
