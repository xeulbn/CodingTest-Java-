import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr=new int[k];
        for(int i=0;i<k;i++){
            st= new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long answer = binarySearch(n);
        System.out.println(answer);
    }

    public static long binarySearch(int n){
        long left =1;
        long right=arr[arr.length-1];
        long max=0;
        while(left<=right){
            long mid = (left+right)/2;
            long cnt =devideCnt(mid);

            if(cnt>=n){
                max=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return max;
    }

    public static long devideCnt(long length){
        long count =0;
        
        for(int i=0;i<arr.length;i++){
            count = count + arr[i]/length;
        }

        return count;
    }
}