import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,- 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int maxHeight = -1;

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight,map[i][j]);
            }
        }

        int maxArea=0;
        for(int i=0;i<maxHeight+1;i++){
            int result= countArea(i);
            if(result>maxArea){
                maxArea=result;
            }
        }
        System.out.println(maxArea);
    }
    public static int countArea(int x){
        checked = new boolean[n][n];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!checked[i][j]&&map[i][j]>x){
                    count++;
                    bfs(i,j,x);
                }
            }
        }
        return count;
    }

    static void bfs(int nowY, int nowX, int height){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(nowY);
        queue.add(nowX);
        checked[nowY][nowX]=true;

        while(!queue.isEmpty()){
            int y=queue.poll();
            int x =queue.poll();

            for(int i=0;i<4;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];

                if(ny<0||ny>=n||nx<0||nx>=n||checked[ny][nx]||map[ny][nx]<=height){
                    continue;
                }
                checked[ny][nx]=true;
                queue.add(ny);
                queue.add(nx);
            }

        }

    }
}
