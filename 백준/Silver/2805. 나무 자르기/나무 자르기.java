import java.io.*;
import java.util.*;


public class Main {
    public static int n;
    public static int m;
    public static int[] height;
    public static int[] afterCut;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer=0;
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        height=new int[n];

        st=new StringTokenizer(br.readLine());
        for (int i=0; i<n;i++){
            height[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(height);

        int low = 0;
        int high= Arrays.stream(height).max().getAsInt();

        while(low<=high){
            int mid=(low+high)/2;
            long sum = getCutSum(mid);

            if(sum>=m){
                answer=mid;
                low=mid+1;
            } else{
                high=mid-1;
            }
        }

        System.out.println(answer);

    }

    public static long getCutSum(int tmp){
        long sum=0;
        for(int h: height){
            if(h>tmp){
                sum+=(h-tmp);
            }
        }
        return sum;
    }
}
