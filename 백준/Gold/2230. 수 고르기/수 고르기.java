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
        arr= new int[N];

        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int end=1;
        int start=0;
        int minDiff= Integer.MAX_VALUE;

        while(end<N){
            if(arr[end]-arr[start]<M){
                end++;
                continue;
            }

            if(arr[end]-arr[start]==M){
                minDiff=M;
                break;
            }

            minDiff=Math.min(minDiff,arr[end]-arr[start]);
            start++;
        }

        System.out.println(minDiff);


    }
}
