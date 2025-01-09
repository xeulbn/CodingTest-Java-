import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        line = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            line[Integer.parseInt(st.nextToken())] = i;
        }

        int max=1;
        int cnt=0;

        for(int i=1;i<=N;i++){
            if(line[i]>line[i-1]){
                if(++cnt>max)
                    max=cnt;
            }else {
                cnt=1;
            }
        }
        System.out.println(N-max);

    }
}
