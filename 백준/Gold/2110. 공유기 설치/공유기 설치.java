import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr=new int[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = upperBound(c);
        System.out.println(answer);
    }

    public static int upperBound(int c){
        int left =1;
        int right = arr[arr.length-1]-arr[0];
        int answer=0;

        while(left<=right){
            int mid = (left+right)/2;

            if(canInstall(mid)>=c){
                answer=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return answer;
    }

    public static int canInstall(int mid){
        int cnt=1;
        int lastIndex=0;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[lastIndex]>=mid){
                cnt++;
                lastIndex=i;
            }
        }
        return cnt;
    }
}