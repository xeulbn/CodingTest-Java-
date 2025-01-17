import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int K;
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

        int maxLen=0;
        int start=0;
        int end=0;
        int cnt=0;

        while(end<N){
            if(cnt<K){
                if(arr[end]%2 !=0 ){
                    cnt++;
                }
                end++;
                maxLen=Math.max(end-start-cnt,maxLen);
            }else if(arr[end]%2 ==0){
                end++;
                maxLen=Math.max(end-start-cnt,maxLen);
            } else{
                if(arr[start]%2!=0){
                    cnt--;
                }
                start++;
            }
        }

        System.out.println(maxLen);

    }
}
