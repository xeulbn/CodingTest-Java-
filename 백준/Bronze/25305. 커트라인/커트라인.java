import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    public static int n;
    public static int k;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());
        arr = new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(arr[n-k]);

        
        
    }
    
}