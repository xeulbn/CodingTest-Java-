import java.io.*;
import java.util.*;;

public class Main {

    public static int n;
    public static int s;
    public static int[] arr;
    public static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());;

        n=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        arr=new int[n];
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(s==0 ? count-1 : count);
    }

    public static void dfs(int index, int sum) {
        if(index==n){
            if(sum==s){
                count++;
            }
            return;
        }

        dfs(index+1,sum+arr[index]);
        dfs(index+1,sum);

    }
}
