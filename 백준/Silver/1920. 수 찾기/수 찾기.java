import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] arr;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        arr =new int[n];
        st =new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st=new StringTokenizer(br.readLine());
        int m =Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int answer = binarySearch(Integer.parseInt(st.nextToken()));
            System.out.println(answer);
        }
    }

    public static int binarySearch(int x){
        int left =0;
        int right=arr.length-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(arr[mid]==x){
                return 1;
            }

            if(arr[mid]>x){
                right=mid-1;
            }
            if(arr[mid]<x){
                left=mid+1;
            }
        }
        return 0;
    }
}