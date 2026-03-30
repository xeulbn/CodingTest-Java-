import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum=0;
        for(int i=0;i<5;i++){
            int score = Integer.parseInt(br.readLine());
            sum+=score;
        }
        System.out.println(sum);
    }
}