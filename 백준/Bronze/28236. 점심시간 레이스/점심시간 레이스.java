import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int n; //학교층수
    public static int m; //한층 교실수
    public static int k; //참가 반 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int bestTime = Integer.MAX_VALUE;
        int bestIdx = 1;
        
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int t = (m+1-x)+(y-1);

            if (t < bestTime) {
                bestTime = t;
                bestIdx = i + 1;
            }
        }

        System.out.println(bestIdx);
        
    }
}