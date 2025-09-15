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
    public static boolean[][] visited;
    public static int[][] result;
    public static int[] dx={-1,1,0,0};
    public static int[] dy={0,0,-1,1};

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken()); //세로
        m= Integer.parseInt(st.nextToken()); //가로

        map= new int[n][m];
        visited= new boolean[n][m];
        result = new int [n][m];
        int xIndex=0;
        int yIndex=0;


        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    xIndex=i;
                    yIndex=j;
                }else if(map[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }

        bfs(xIndex,yIndex);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    result[i][j]=-1;
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y){
        Queue<Node> queue= new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y]=true;
        result[x][y] = 0;

        while(!queue.isEmpty()){
            Node node= queue.poll();
            for(int i=0;i<4;i++){
                int nextX=node.x+dx[i];
                int nextY=node.y+dy[i];

                if(nextX>=0&&nextX<n&& nextY>=0&&nextY<m){
                    if(!visited[nextX][nextY]&&map[nextX][nextY] != 0){
                        visited[nextX][nextY]=true;
                        result[nextX][nextY]=result[node.x][node.y]+1;
                        queue.add(new Node(nextX,nextY));
                    }
                }
            }
        }
    }
}
