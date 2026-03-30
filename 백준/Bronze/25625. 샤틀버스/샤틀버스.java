import java.util.*;
import java.lang.*;
import java.io.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int x= Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int answer=0;
        if(x>=y){
            answer= x+y;
        }else{
            answer= y-x;
        }
        System.out.println(answer);
    }
}