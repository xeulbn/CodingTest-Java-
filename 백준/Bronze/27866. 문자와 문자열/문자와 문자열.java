import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        st=new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        
        System.out.println(str.charAt(a-1));
    }
}