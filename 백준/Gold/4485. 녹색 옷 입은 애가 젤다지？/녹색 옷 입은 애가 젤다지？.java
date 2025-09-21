import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] map;
    public static boolean[][]visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static class Node{
        int x;
        int y;
        int cost;
        Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase=1;
        String line;

        while((line=br.readLine())!=null){
            line=line.trim();
            if(line.isEmpty()){
                continue;
            }
            StringTokenizer st = new StringTokenizer(line);
            n= Integer.parseInt(st.nextToken());
            if(n==0){
                break;
            }

            map= new int[n][n];
            visited =  new boolean[n][n];
            for(int i=0;i<n;i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    map[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            int answer = dijkstra(0,0,map[0][0]);
            System.out.println("Problem "+ testCase + ": "+answer);
            testCase++;
        }
    }

    public static int dijkstra(int start, int end, int cost) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost));
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[start][end]=cost;
        pq.add(new Node(start, end, cost));

        while(!pq.isEmpty()){
            Node current= pq.poll();
            int x = current.x;
            int y= current.y;
            int c = current.cost;

            if(visited[x][y]){
                continue;
            }
            visited[x][y]=true;

            if(x==n-1&&y==n-1){
                return c;
            }

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0||ny<0||nx>=n||ny>=n){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }

                int nextCost = c+map[nx][ny];
                if(nextCost<dist[nx][ny]){
                    dist[nx][ny] = nextCost;
                    pq.add(new Node(nx,ny,nextCost));
                }
            }
        }
        return -1;
    }
}
