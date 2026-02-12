import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    public static int n;
    public static ArrayList<Integer> number;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        number = new ArrayList<>();
        
        while(n>0){
            number.add(n%10);
            n=n/10;
        }

        Collections.sort(number,(a,b)->b-a);
        int answer=0;
        for(int a : number){
            answer=answer*10+a;
        }

        System.out.println(answer);
    }
    
}