import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static int[] arr;
    public static int x;
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        x=Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int left=0;
        int right=arr.length-1;

        int answer=0;
        while(left<right){
            if(arr[left]+arr[right]==x){
                answer++;
                left++;
                right--;
            }else if(arr[left]+arr[right]<x){
                left++;
            }else{
                right--;
            }
        }

        System.out.println(answer);
        
    }
    
}