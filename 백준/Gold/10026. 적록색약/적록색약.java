import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static String[][] map;
    public static boolean[][] visited;
    public static int[] dx={0,0,1,-1};
    public static int[] dy={1,-1,0,0};

    public static class Node{
        public int x;
        public int y;

        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        map=new String[n][n];
        visited=new boolean[n][n];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }
        int Rcount=0;
        int Gcount=0;
        int Bcount=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j].equals("R")&&!visited[i][j]){
                    bfs(i,j);
                    Rcount++;
                }else if (map[i][j].equals("G")&&!visited[i][j]){
                    bfs(i,j);
                    Gcount++;
                }else if (map[i][j].equals("B")&&!visited[i][j]){
                    bfs(i,j);
                    Bcount++;
                }
            }
        }
        int normal=Rcount+Gcount+Bcount;
        visited=new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j].equals("G")) {
                    map[i][j]="R";
                }
            }
        }

        int abnormalRcount=0;
        int abnormalBcount=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j].equals("R")&&!visited[i][j]) {
                    bfs(i, j);
                    abnormalRcount++;
                }else if (map[i][j].equals("B")&&!visited[i][j]){
                    bfs(i,j);
                    abnormalBcount++;
                }
            }
        }
        int abnormalTotal=abnormalRcount+abnormalBcount;


        System.out.println(normal + " " + abnormalTotal);
    }

    public static void bfs(int x,int y){
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y]=true;

        while(!queue.isEmpty()){
            Node cur=queue.poll();
            int nowX=cur.x;
            int nowY=cur.y;

            for(int i=0;i<4;i++){
                int nextX=cur.x+dx[i];
                int nextY=cur.y+dy[i];

                if(0<=nextX&&nextX<n&&0<=nextY&&nextY<n&&!visited[nextX][nextY]&&map[nextX][nextY].equals(map[x][y])){
                    visited[nextX][nextY]=true;
                    queue.offer(new Node(nextX,nextY));
                }
            }
        }
    }
}
