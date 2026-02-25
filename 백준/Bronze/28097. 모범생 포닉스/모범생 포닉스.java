import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final int BREAK_TIME_SPENT = 8;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        int answer=0;
        for(int i=0;i<n;i++){
            if(i==n-1){
                answer+=Integer.parseInt(st.nextToken());
            }else{
                answer+=Integer.parseInt(st.nextToken())+BREAK_TIME_SPENT;
            }
        }

        int day=answer/24;
        int time =answer%24;
        
        System.out.println(day+" "+time);
    }
}