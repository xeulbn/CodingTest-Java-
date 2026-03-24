import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        long answer= solvePactorial(n);

        System.out.println(answer);
    }

    public static long solvePactorial(int x){
        long value=1L;
        if(x==0){
            return 1;
        }
        for(int i=1;i<=x;i++){
            value=value*i;
        }
        return value;
    }
    
}