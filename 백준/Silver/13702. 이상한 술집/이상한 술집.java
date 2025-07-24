import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int k;
    public static long[] capacity;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        capacity=new long[n];

        long sum=0;

        for(int i=0;i<n;i++){
            capacity[i]=Long.parseLong(br.readLine());
            sum+=capacity[i];
        }

        long high= sum/k;
        long low=1;
        long answer=0;

        while(low<=high){
            long mid =(low+high)/2;
            int count=0;

            for(int i=0;i<n;i++){
                count+=(capacity[i]/mid);
            }

            if(count>=k){
                answer=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        System.out.println(answer);
    }
}
