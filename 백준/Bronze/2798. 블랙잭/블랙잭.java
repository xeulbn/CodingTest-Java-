import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] card = new int[n];
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            card[i]=Integer.parseInt(st.nextToken());
        }

        int maxSum = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(card[i]+card[j]+card[k]<=m){
                        maxSum=Math.max(maxSum,(card[i]+card[j]+card[k]));
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}