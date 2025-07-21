import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        tree= new int[n];

        for(int i=0;i<n;i++){
            tree[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        int min = 0;
        int max= tree[n-1];

        int answer=0;

        while(min<=max){
            int mid= (min+max)/2;

            long sum=0;
            for(int i=0;i<n;i++){
                if(tree[i]>mid){
                    sum+=tree[i]-mid;
                }
            }

            if(sum>=m){
                answer=mid;
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        System.out.println(answer);
    }
}
