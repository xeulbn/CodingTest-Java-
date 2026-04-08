import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] dx={-1,1,0,0};
    public static int[] dy={0,0,-1,1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        while(true){
            st= new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            if(w==0&&h==0){
                break;
            }

            char[][] map = new char[h][w];
            int robotX=0;
            int robotY=0;

            List<int[]> dirty=new ArrayList<>();
            for(int i=0;i<h;i++){
                String str = br.readLine();
                for(int j=0;j<w;j++){
                    map[i][j]=str.charAt(j);   
                    if(map[i][j]=='*'){
                        dirty.add(new int[]{i,j});
                    }
                    if(map[i][j]=='o'){
                        robotX=i;
                        robotY=j;
                    }
                }
            }

            List<int[]> points = new ArrayList<>();
            points.add(new int[]{robotX,robotY});
            for(int[] d: dirty){
                points.add(d);
            }

            int size = points.size();
            int[][] graph = new int[size][size];
            boolean impossible = false;

            for (int i=0; i<size; i++) {
                int[] start = points.get(i);
                int[][] dist = bfs(start[0],start[1],h,w,map);
            
                for (int j=0; j<size; j++) {
                    int[] end = points.get(j);
                    graph[i][j] = dist[end[0]][end[1]];
                }
            }
            for (int i = 1; i<size; i++) {
                if (graph[0][i] == -1) {
                    impossible=true;
                    break;
                }
            }
            
            if (impossible) {
                sb.append(-1).append('\n');
                continue;
            }
            int answer = tsp(graph, dirty.size());
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }

    public static int[][] bfs(int startx,int starty,int n,int m,char[][] board){
        int[][] dist = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        Queue<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{startx, starty});
        dist[startx][starty] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
    
            for (int dir=0; dir<4; dir++) {
                int nx = x+dx[dir];
                int ny = y+dy[dir];
    
                if (nx<0 || nx>=n || ny<0 || ny>=m){
                    continue;                    
                }
                if (board[nx][ny]=='x'){
                    continue;
                }
                if (dist[nx][ny]!=-1){
                    continue;
                }
    
                dist[nx][ny] = dist[x][y]+1;
                q.offer(new int[]{nx, ny});
            }
        }
    
        return dist;
    }

    public static int tsp(int[][] graph, int dirtyCount) {
        int fullMask = (1<<dirtyCount)-1;
        int size = dirtyCount+1;
        int INF = 1000000000;
    
        int[][] dp = new int[1 << dirtyCount][size];
        for (int i = 0; i < (1 << dirtyCount); i++) {
            Arrays.fill(dp[i], INF);
        }
    
        dp[0][0] = 0;
    
        for (int mask = 0; mask <= fullMask; mask++) {
            for (int cur = 0; cur < size; cur++) {
                if (dp[mask][cur] == INF) continue;
    
                for (int next = 1; next < size; next++) {
                     // 이미 방문
                    if ((mask & (1 << (next - 1))) != 0){
                        continue;
                    }
                    // 못 감
                    if (graph[cur][next] == -1){
                       continue;  
                    } 
    
                    int nextMask = mask | (1<<(next-1));
                    dp[nextMask][next] = Math.min(dp[nextMask][next], dp[mask][cur] + graph[cur][next]);
                }
            }
        }
    
        int answer = INF;
        for (int i = 0; i < size; i++) {
            answer = Math.min(answer, dp[fullMask][i]);
        }
    
        return answer;
    }
}