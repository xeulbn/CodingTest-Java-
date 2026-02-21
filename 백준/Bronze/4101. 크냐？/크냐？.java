import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st=new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n==0 && m==0)
                break;

            if(n>m){
                sb.append("Yes").append("\n");
            }else{
                sb.append("No").append("\n");
            }
        }
        System.out.println(sb);
        
    }
}