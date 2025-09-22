import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int t;
    public static int[] dp;
    public static int[] qs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t=Integer.parseInt(st.nextToken());
        qs= new int[t];
        int max=0;

        for(int i=0;i<t;i++){
            st= new StringTokenizer(br.readLine());
            qs[i]= Integer.parseInt(st.nextToken());
            if(qs[i]>max){
                max=qs[i];
            }
        }

        dp=new int[max+1];
        dp[0]=1;
        int[] coins={1,2,3};
        for(int c: coins){
            for(int i=c;i<=max;i++){
                dp[i]+=dp[i-c];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n: qs){
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
