import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st=new StringTokenizer(br.readLine());
        int m =Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        StringBuilder sb =new StringBuilder();
        for(int i=0;i<m;i++){
            int target = Integer.parseInt(st.nextToken());
            int answer = upperBound(target)-lowerBound(target);
            sb.append(answer).append(' ');
        }

        System.out.print(sb);
    }

    public static int lowerBound(int target){
        int left = 0;
        int right= arr.length;
        while(left<right){
            int mid = (left+right)/2;

            if(arr[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static int upperBound(int target){
        int left=0;
        int right = arr.length;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]>target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}