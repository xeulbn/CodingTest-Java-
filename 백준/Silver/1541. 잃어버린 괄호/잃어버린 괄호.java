import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(),"-");

        int answer= Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            int tmp = 0;
            StringTokenizer str= new StringTokenizer(st.nextToken(),"+");

            while(str.hasMoreTokens()){
                tmp+= Integer.parseInt(str.nextToken());
            }

            if(answer==Integer.MAX_VALUE){
                answer= tmp;
            }else{
                answer-=tmp;
            }
        }
        System.out.println(answer);
    }
}
