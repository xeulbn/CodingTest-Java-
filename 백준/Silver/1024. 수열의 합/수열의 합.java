import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int l;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        
        for (int len = l; len <= 100; len++) {
            if ((2*n)%len != 0) 
                continue;

            int temp = (2*n)/len -len+1;
            
            if (temp%2 != 0) 
                continue;

            int start = temp / 2;
            
            if (start < 0) 
                continue;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(start + i).append(" ");
            }
            
            System.out.println(sb);
            return;
        }

        System.out.println(-1);
    }
}