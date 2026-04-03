import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());

        int score = 10*n;
        if(n>=3){
            score+=20;
        }

        if(n>=5){
            score+=50;
        }
        
        if(w>1000){
            score-=15;
        }

        int answer = (score<0? 0 : score);
        System.out.println(answer);
    }
}