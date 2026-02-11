import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    public static int n;
    public static int[] arr;
    public static int[] lis;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        arr=new int[n];
        lis=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        lis[0]=arr[0];
        int lisLength=1;
        for(int i=1;i<n;i++){
            int key= arr[i];

            if(key>lis[lisLength-1]){
                lisLength++;
                lis[lisLength-1]=key;
            }else{
                int left = 0;
                int right= lisLength-1;
                while(left<right){
                    int mid = (left+right)/2;
                    
                    if(lis[mid]<key){
                        left=mid+1;
                    }else{
                        right= mid;
                    }
                }
                lis[left]=key;
            }
        }
        System.out.println(lisLength);
        
    }
    
}