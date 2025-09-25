import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int k;
    public static int[] belt;
    public static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        k =  Integer.parseInt(st.nextToken());
        belt = new int[2*n];
        robot = new boolean[n];
        int zeroCnt =0;

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<2*n;i++){
            belt[i]= Integer.parseInt(st.nextToken());
            if(belt[i]==0){
                zeroCnt++;
            }
        }

        int answer=0;
        while(k>zeroCnt){
            answer++;

            //벨트 로봇 둘다 회전시키자
            int last = belt[2*n-1];
            for(int i=2*n-1;i>=1;i--){
                belt[i]=belt[i-1];
            }
            belt[0]=last;

            for(int i=n-1;i>=1;i--){
                robot[i]=robot[i-1];
            }
            robot[0]=false;
            robot[n-1]=false;


            for(int i=n-2;i>=0;i--){
                if(robot[i]&&!robot[i+1]&&belt[i+1]>0){
                    robot[i]=false;
                    robot[i+1]=true;
                    belt[i+1]--;
                    if(belt[i+1]==0){
                        zeroCnt++;
                    }
                }
            }
            robot[n-1]=false;

            if(belt[0]>0 && !robot[0]){
                robot[0]=true;
                belt[0]--;
                if(belt[0]==0){
                    zeroCnt++;
                }
            }
        }

        System.out.println(answer);

    }
}
