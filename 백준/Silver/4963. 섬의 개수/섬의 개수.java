import java.io.*;
import java.util.*;

public class Main {

    public static int w;
    public static int h;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;


        while (true){
            st=new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h= Integer.parseInt(st.nextToken());

            if(w==0&&h==0)
                break;

            map=new int[h][w];
            visited=new boolean[h][w];
            for(int i=0;i<h;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visited[i][j]&&map[i][j]==1){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        visited[x][y]=true;

        while(!queue.isEmpty()){
            Node cur= queue.poll();
            int nowX = cur.x;
            int nowY = cur.y;

            for( int i=0;i<8;i++){
                int nextX=nowX+dx[i];
                int nextY=nowY+dy[i];

                if(nextX>=0&&nextX<h&&nextY>=0&&nextY<w){
                    if(!visited[nextX][nextY]&&map[nextX][nextY]==1){
                        visited[nextX][nextY]=true;
                        queue.offer(new Node(nextX,nextY));
                    }
                }
            }
        }

    }


}
