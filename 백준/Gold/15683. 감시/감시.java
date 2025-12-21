import java.io.*;
import java.util.*;

public class Main {

    /*
      1~5 : cctv 번호
      6 : 벽
      0 : 빈칸
     */

    private static int n; // 세로
    private static int m; // 가로
    private static int[][] office;

    // 상, 우, 하, 좌 (시계방향)
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static List<CCTV> cctvs = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;

    private static class CCTV {
        int x, y, type;
        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    // CCTV 타입별 "방향 조합(회전 케이스)" 정의
    // 각 케이스는 {dir1, dir2, ...} 형태 (dir은 0~3: 상우하좌)
    private static final int[][][] DIRS = {
            {}, // 0번은 사용 안 함
            { {0}, {1}, {2}, {3} },                          // 1
            { {0,2}, {1,3} },                                // 2
            { {0,1}, {1,2}, {2,3}, {3,0} },                  // 3
            { {0,1,2}, {1,2,3}, {2,3,0}, {3,0,1} },          // 4
            { {0,1,2,3} }                                    // 5
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        office = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                int v = office[i][j];
                if (v >= 1 && v <= 5) {
                    cctvs.add(new CCTV(i, j, v));
                }
            }
        }

        dfs(0, office);
        System.out.println(answer);
    }

    // idx번째 CCTV의 방향 케이스를 선택해가며 백트래킹
    private static void dfs(int idx, int[][] board) {
        if (idx == cctvs.size()) {
            answer = Math.min(answer, countBlind(board));
            return;
        }

        CCTV cur = cctvs.get(idx);
        int type = cur.type;

        for (int[] dirCase : DIRS[type]) {
            int[][] copied = copy(board);

            // 현재 CCTV의 dirCase 방향으로 감시 표시
            for (int d : dirCase) {
                watch(copied, cur.x, cur.y, d);
            }

            dfs(idx + 1, copied);
        }
    }

    // 한 방향으로 벽(6) 만날 때까지 직선 감시 처리
    // 감시된 빈칸(0)은 -1로 바꿔서 표시
    private static void watch(int[][] board, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (0 <= nx && nx < n && 0 <= ny && ny < m) {
            if (board[nx][ny] == 6) break;      // 벽이면 종료
            if (board[nx][ny] == 0) board[nx][ny] = -1; // 빈칸이면 감시 표시
            // CCTV(1~5)나 이미 감시(-1)는 그냥 통과
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    private static int countBlind(int[][] board) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    private static int[][] copy(int[][] src) {
        int[][] dst = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, m);
        }
        return dst;
    }
}
