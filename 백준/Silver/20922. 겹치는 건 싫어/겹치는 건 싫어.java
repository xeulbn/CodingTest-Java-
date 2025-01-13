import java.io.*;
import java.util.*;

public class Main {

    public static int K;
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        arr=new int[N];

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int start=0;
        int end=0;
        int []count= new int[100001];
        int maxLen=0;

        while(end<N){
            while(end<N && count[arr[end]]+1<=K){
                count[arr[end]]++;
                end++;
            }
            int len = end-start;
            maxLen= Math.max(maxLen,len);
            count[arr[start]]--;
            start++;
        }

        System.out.println(maxLen);
    }
}
