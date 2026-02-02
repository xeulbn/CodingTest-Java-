import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long a = Long.parseLong(st.nextToken());
        Long b= Long.parseLong(st.nextToken());
        Long c = Long.parseLong(st.nextToken());
        Long d =Long.parseLong(st.nextToken());
        Long e = Long.parseLong(st.nextToken());
        Long f = Long.parseLong(st.nextToken());
        
        if(a*e-b*d==0){
            System.out.println("0 0");
            return;
        }

        Long y = solutionY(a,b,c,d,e,f);
        Long x = solutionX(a,b,c,d,e,f,y);

        System.out.println(x+" "+y);
        
    }

    public static Long solutionY(Long a, Long b, Long c, Long d, Long e, Long f) {
        return (a * f - d * c) / (a * e - b * d);
    }

    public static Long solutionX(Long a, Long b, Long c, Long d,Long e,Long f, Long y) {
        return a !=0 ? (c-b*y)/a : (f-e*y)/d;
    }
}