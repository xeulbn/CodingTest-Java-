import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 강의실 개수
        int m = Integer.parseInt(st.nextToken()); // 예약 요청 수

        int[] lastEnd = new int[n+1];

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (lastEnd[k] <= s) {
                sb.append("YES\n");
                lastEnd[k] = e;
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}