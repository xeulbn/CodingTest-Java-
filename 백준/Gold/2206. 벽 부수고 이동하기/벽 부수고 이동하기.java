import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[][] map;
    public static boolean[][][] visited;
    public static int[][][] dist;
    public static int[] dx={-1,1,0,0};
    public static int[] dy={0,0,-1,1};

    public static class Node{
        int x = 0;
        int y = 0;

        int wallBreak=0;

        Node(int x,int y,int wallBreak){
            this.x = x;
            this.y = y;
            this.wallBreak = wallBreak;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        map= new int[n][m];
        visited=new boolean[n][m][2];

        for(int i=0;i<n;i++){
            String line = br.readLine().trim();
            for(int j=0;j<m;j++){
                map[i][j]= line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));

    }

    public static int bfs(int x, int y){
        Queue<Node> queue= new LinkedList<>();
        queue.offer(new Node(x,y,0));
        visited[x][y][0]=true;
        dist =new int[n][m][2];
        dist[0][0][0]=1;

        while(!queue.isEmpty()){
            Node node= queue.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return dist[node.x][node.y][node.wallBreak];
            }


            for(int i=0;i<4;i++){
                int nx=node.x+dx[i];
                int ny=node.y+dy[i];

                if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                    continue;
                }
                if(map[nx][ny]==0&& !visited[nx][ny][node.wallBreak]){
                    visited[nx][ny][node.wallBreak]=true;
                    dist[nx][ny][node.wallBreak]=dist[node.x][node.y][node.wallBreak]+1;
                    queue.offer(new Node(nx,ny,node.wallBreak));
                    continue;
                }

                if(map[nx][ny]==1&&node.wallBreak==0&& !visited[nx][ny][1]){
                    visited[nx][ny][1]=true;
                    dist[nx][ny][1]=dist[node.x][node.y][0]+1;
                    queue.offer(new Node(nx,ny,1));
                }
            }
        }
        return -1;
    }
}
