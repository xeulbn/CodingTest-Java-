import java.io.*;
import java.util.*;

public class Main {

    public static int T;
    public static int N;
    public static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long answer=0;

        T = Integer.parseInt(st.nextToken());

        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            arr=new int[N];
            answer=0;
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }

            long maxValue=0;
            for(int j=N-1;j>=0;j--){
                if(arr[j]>=maxValue){
                    maxValue=arr[j];
                }else{
                    answer+=maxValue-arr[j];
                }
            }
            System.out.println(answer);
        }
    }
}
