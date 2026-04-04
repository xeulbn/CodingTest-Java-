import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int[] arr;
    public static int s;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        arr=new int[n];
        st= new StringTokenizer(br.readLine());
        
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        s=Integer.parseInt(st.nextToken());

        for(int i=0;i<n-1 && s>0;i++){
            int maxIdx = i;
            for (int j= i+1; j<n && j<=i+s; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            for (int j = maxIdx; j>i; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }

            s-=(maxIdx-i);

        }

        StringBuilder sb= new StringBuilder();
        for(int num : arr){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}