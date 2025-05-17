import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        arr=new int[n];


        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer=0;

        for(int i=0;i<n;i++){
            int target=arr[i];
            int left=0;
            int right=n-1;

            while(left<right){
                if(left==i){
                    left++;
                    continue;
                }
                if(right==i){
                    right--;
                    continue;
                }

                int sum=arr[left]+arr[right];
                if(sum==target){
                    answer++;
                    break;
                }else if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        System.out.println(answer);
    }


}
