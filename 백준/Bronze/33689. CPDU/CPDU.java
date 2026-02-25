import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());

        int answer =0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(name.charAt(0)=='c'||name.charAt(0)=='C'){
                answer=answer+1;
            }
        }
        System.out.println(answer);
    }
}