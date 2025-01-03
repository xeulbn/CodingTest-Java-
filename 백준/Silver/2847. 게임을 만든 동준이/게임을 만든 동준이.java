import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int answer=0;

        level = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            level[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-2;i>=0;i--){
            while(level[i]>=level[i+1]){
                level[i]-=1;
                answer++;
            }
        }
        System.out.println(answer);

    }


}
