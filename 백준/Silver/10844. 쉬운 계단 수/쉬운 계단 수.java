import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static Long[][] dp;
    public static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        dp= new Long[n+1][10];
        for(int i = 0; i < 10; i++) {
			dp[1][i] = 1L;
		}

        Long answer =0L;
        
        for(int i = 1; i <= 9; i++) {
			answer = (answer+ findAnswer(n, i))% MOD;
		}
        System.out.println(answer);
    }

    public static long findAnswer(int digit, int value){
        if(digit==1){
            return dp[digit][value];
        }
        
        if(dp[digit][value] != null){
            return dp[digit][value];
        }

        if(value==9){
            dp[digit][value]=findAnswer(digit-1,8)%MOD;
        }else if (value == 0){
            dp[digit][value]=findAnswer(digit-1,1)%MOD;
        }else{
            dp[digit][value]=(findAnswer(digit-1,value+1)+findAnswer(digit-1,value-1))%MOD;
        }

        return dp[digit][value]%MOD;
    } 
}