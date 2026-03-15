import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int n;
    public static int k;
    public static int[] a;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());

        int index=0;
        a=new int[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            a[i]=Integer.parseInt(st.nextToken());
            if(a[i]<=k){
                index=i;
            }
        }

        int answer=0;

        for(int i=index;i>=0;i--){
            answer=answer+k/a[i];
            k=k%a[i];
            if(k==0){
                break;
            }
        }
        System.out.println(answer);
    }
    

}