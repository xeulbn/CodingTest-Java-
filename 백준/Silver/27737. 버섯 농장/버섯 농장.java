import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int k;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx={0,0,1,-1};
    public static int[] dy={1,-1,0,0};

    public static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited= new boolean[n][n];

        for (int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalNeed =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&map[i][j]==0){
                    int area = bfs(i,j);
                    totalNeed += (area+k-1)/k;
                }
            }
        }

        if (totalNeed == 0) {
            System.out.println("IMPOSSIBLE");
        } else if (totalNeed <= m) {
            System.out.println("POSSIBLE");
            System.out.println(m-totalNeed);
        } else {
            System.out.println("IMPOSSIBLE");
        }


    }

    public static int bfs(int x,int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        visited[x][y]=true;

        int areaSize=1;

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int nowX = cur.x;
            int nowY = cur.y;

            for( int i=0;i<4;i++){
                int nextX=nowX+dx[i];
                int nextY=nowY+dy[i];

                if(0<=nextX&&nextX<n&&0<=nextY&&nextY<n&&!visited[nextX][nextY]&&map[nextX][nextY]==0){
                    visited[nextX][nextY]=true;
                    queue.offer(new Node(nextX,nextY));
                    areaSize++;
                }
            }
        }

        return areaSize;
    }
}
