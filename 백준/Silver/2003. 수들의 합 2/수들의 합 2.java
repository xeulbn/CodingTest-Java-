import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());

        arr= new int[N];
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int answer=0;
        int start=0, end=0, sum=0;

        while(end<N){
            sum+=arr[end];
            while(sum>M){
                sum=sum-arr[start];
                start++;
            }
            if(sum==M){
                answer++;
            }
            end++;
        }
        System.out.println(answer);

    }
}
