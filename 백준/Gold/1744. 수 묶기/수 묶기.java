import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        arr= new int[N];
        int minusCnt=0;

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            arr[i]= Integer.parseInt(st.nextToken());
            if(arr[i]<=0){
                minusCnt++;
            }
        }

        Arrays.sort(arr);
        int answer=0;
        for(int i=1;i<minusCnt;i+=2){
            answer+=(arr[i-1]*arr[i]);
        }

        if(minusCnt%2==1){
            answer+=arr[minusCnt-1];
        }

        if((N-minusCnt)%2==1){
            answer+=arr[minusCnt];
        }

        for(int i=N-1;i>minusCnt;i-=2){
            int mul=arr[i]*arr[i-1];
            int sum= arr[i]+arr[i-1];
            answer+=Math.max(mul,sum);
        }

        System.out.println(answer);
    }
}
