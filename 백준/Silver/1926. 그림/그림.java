import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,-0,-1,1};
    static int maxArea;
    static int pictureCount=0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            String s[] = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (map[i][j] == 1 && !visited[i][j]) {
                    int area = bfs(i, j);
                    maxArea = Math.max(maxArea, area);
                    pictureCount++;
                }

            }
        }

        System.out.println(pictureCount);
        System.out.println(maxArea);

    }

    public static int bfs(int x, int y){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]=true;

        int area=1;

        while(!queue.isEmpty()){
            int now[]=queue.poll();
            int nowX=now[0];
            int nowY=now[1];

            for(int i=0;i<4;i++){
                int nextX=nowX+dx[i];
                int nextY=nowY+dy[i];

                if(nextX<0 || nextX>=n || nextY<0 || nextY>=m){
                    continue;
                }
                if(map[nextX][nextY]==1 && !visited[nextX][nextY]){
                    queue.add(new int[]{nextX,nextY});
                    visited[nextX][nextY]=true;
                    area++;
                }


            }
        }
        return area;
    }

}