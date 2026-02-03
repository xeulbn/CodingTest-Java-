import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int answer = findMovieName(n);
        System.out.println(answer);
    }

    public static int findMovieName(int n){
        int count = 1;
        int number =666;
        if(n==1){
            return number;
        }
        while(count!=n){
            number++;
            if(String.valueOf(number).contains("666")){
                count++;
            }
        }
        return number;
    }
}