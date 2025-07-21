import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static long[] feature;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        feature= new long[n];
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            feature[i]=Long.parseLong(st.nextToken());
        }

        int left= 0;
        int right= n-1;
        int indexLeft=0;
        int indexRight=0;
        long min = Long.MAX_VALUE;

        while(left<right){
            long sum= feature[left]+feature[right];
            if(min>Math.abs(sum)){
                min= Math.abs(sum);
                indexLeft=left;
                indexRight=right;
            }
            if(sum>=0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(feature[indexLeft]+" "+feature[indexRight]);

    }
}
