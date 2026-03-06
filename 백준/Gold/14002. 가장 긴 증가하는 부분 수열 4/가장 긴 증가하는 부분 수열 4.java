import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] dp;
    public static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        dp= new int[n+1];
        st= new StringTokenizer(br.readLine());

        int answer=0;
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);                    
                }

                answer=Math.max(dp[i],answer);
            }
        }

        StringBuilder sb= new StringBuilder();
        sb.append(answer).append("\n");
        int value= answer;
        int last = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i=n;i>=1;i--){
            if(value==dp[i]&&arr[i]<last){
                stack.push(arr[i]);
                value--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}