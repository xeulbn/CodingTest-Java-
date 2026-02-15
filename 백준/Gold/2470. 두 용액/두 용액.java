import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static int[] arr;
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left=0;
        int right = arr.length-1;
        int min = Integer.MAX_VALUE;

        int[] answer = new int[2];
        while(left<right){
            int sum=arr[left]+arr[right];
            
            if(min>Math.abs(sum)){
                min=Math.abs(sum);
                answer[0]=left;
                answer[1]=right;

                if(sum==0){
                    break;
                }
            }

            if(sum<0){
                left++;
            }else{
                right--;
            }
        }

        System.out.println(arr[answer[0]]+" "+arr[answer[1]]);
        
    }
    
}