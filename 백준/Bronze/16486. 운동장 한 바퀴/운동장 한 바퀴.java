import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static double pi = 3.141592;
    public static int d1;
    public static int d2;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        d1 = Integer.parseInt(br.readLine());
        d2 = Integer.parseInt(br.readLine());

        double answer =solveRound(d1,d2);

        System.out.println(answer);
    }

    public static double solveRound(int nemo, double circle){
        int nemoRound=nemo*2;
        double circleRound= 2*pi*circle;
        
        return (double)nemoRound + circleRound;
    }
    
}