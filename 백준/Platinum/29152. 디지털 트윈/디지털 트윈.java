import java.io.*;
import java.util.*;

class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1') {
                    if (left[i] == -1) left[i] = j;
                    right[i] = j;
                }
            }
        }

        // dp[c] = 현재 행에 열 c로 "진입"했을 때의 최소 이동 횟수
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0; // (0,0)에서 시작

        for (int row = 0; row < n - 1; row++) {
            int[] ndp = new int[n];
            Arrays.fill(ndp, INF);

            int L = left[row];
            int R = right[row];

            if (L == -1) {
                // 빈 행: c -> d 아무렇게나 가능, 비용 |c-d| + 1(아래로 내려감)
                int[] pref = new int[n];
                int[] suff = new int[n];

                pref[0] = dp[0] - 0;
                for (int i = 1; i < n; i++) {
                    pref[i] = Math.min(pref[i - 1], dp[i] - i);
                }

                suff[n - 1] = dp[n - 1] + (n - 1);
                for (int i = n - 2; i >= 0; i--) {
                    suff[i] = Math.min(suff[i + 1], dp[i] + i);
                }

                for (int d = 0; d < n; d++) {
                    int best = Math.min(pref[d] + d, suff[d] - d);
                    if (best < INF) ndp[d] = best + 1;
                }
            } else {
                // 기계가 있는 행: [min(c,d), max(c,d)]가 [L,R]를 포함해야 함

                // 1) c <= L 이고 d >= R
                int bestLeftSide = INF;
                for (int c = 0; c <= L; c++) {
                    if (dp[c] < INF) {
                        bestLeftSide = Math.min(bestLeftSide, dp[c] - c);
                    }
                }
                if (bestLeftSide < INF) {
                    for (int d = R; d < n; d++) {
                        ndp[d] = Math.min(ndp[d], bestLeftSide + d + 1); // (d-c) + 1
                    }
                }

                // 2) c >= R 이고 d <= L
                int bestRightSide = INF;
                for (int c = R; c < n; c++) {
                    if (dp[c] < INF) {
                        bestRightSide = Math.min(bestRightSide, dp[c] + c);
                    }
                }
                if (bestRightSide < INF) {
                    for (int d = 0; d <= L; d++) {
                        ndp[d] = Math.min(ndp[d], bestRightSide - d + 1); // (c-d) + 1
                    }
                }
            }

            dp = ndp;
        }

        // 마지막 행에서는 (n-1,n-1)에서 끝나야 함
        int ansMoves = INF;
        int lastL = left[n - 1];
        int lastR = right[n - 1];

        if (lastL == -1) {
            // 빈 행이면 그냥 현재 열 c에서 n-1까지 가면 됨
            for (int c = 0; c < n; c++) {
                if (dp[c] < INF) {
                    ansMoves = Math.min(ansMoves, dp[c] + Math.abs((n - 1) - c));
                }
            }
        } else {
            // 마지막 행의 기계 [lastL, lastR]를 지나면서 끝점은 n-1
            // 단순 경로로 가능하려면 현재 진입 열 c <= lastL 이어야 함
            for (int c = 0; c <= lastL; c++) {
                if (dp[c] < INF) {
                    ansMoves = Math.min(ansMoves, dp[c] + ((n - 1) - c));
                }
            }
        }

        if (ansMoves >= INF) {
            System.out.println(-1);
        } else {
            // 칸 수 = 이동 횟수 + 시작 칸 1개
            System.out.println(ansMoves + 1);
        }
    }
}