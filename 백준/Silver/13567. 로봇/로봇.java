import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());

        int x=0;
        int y=0;
        int dir=1;

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            if(st.nextToken().charAt(0)=='T'){
                if(st.nextToken().charAt(0)=='0'){
                    dir=(dir+3)%4;
                }else{
                    dir=(dir+1)%4;
                }
            }else{
                int d = Integer.parseInt(st.nextToken());
                if(dir==0){
                    y+=d;
                }else if(dir==1){
                    x+=d;
                }else if(dir==2){
                    y-=d;
                }else{
                    x-=d;
                }

                if(x>=m||y>=m||x<0||y<0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(x+" "+y);

    }
}
