import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int[] dot;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        dot=new int[n];

        for(int i=0;i<n;i++){
            dot[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dot);

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            int left=lowerBound(dot,start);
            int right=upperBound(dot,end);
            System.out.println(right-left);

        }
    }
    public static int lowerBound(int[] arr, int target){
        int left=0;
        int right=arr.length;

        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }

        return left;
    }

    public static int upperBound(int[] arr, int target){
        int left=0;
        int right=arr.length;

        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]<=target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}
