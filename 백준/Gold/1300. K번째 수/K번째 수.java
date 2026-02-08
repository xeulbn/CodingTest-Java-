import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[][] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        long answer=solution(n,k);
        System.out.println(answer);
    }

    public static long solution(int n, int k){
        long left = 1;
        long right = k;

        while(left<right){
            long mid = (left+right)/2;
            long count=0;

            for(int i=1;i<n+1;i++){
                count+=Math.min(mid/i,n);
            }

            if(k<=count){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}