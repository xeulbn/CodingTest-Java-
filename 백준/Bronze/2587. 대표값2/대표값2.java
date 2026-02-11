import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    public static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5];
        int sum =0;
        for(int i=0;i<5;i++){
            st= new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
            sum +=arr[i];
        }

        Arrays.sort(arr);
        System.out.println(sum/5);
        System.out.println(arr[2]);
        
        
    }
    
}