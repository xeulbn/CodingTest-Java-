import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int K;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        arr=new int[N];

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int sum=0;
        for(int i=0;i<K;i++){
            sum+=arr[i];
        }

        int index=0;
        int max=sum;
        for(int i=K;i<N;i++){
            sum+=arr[i]-arr[index];
            if(max<sum){
                max=sum;
            }
            index++;
        }

        System.out.println(max);

    }

}
