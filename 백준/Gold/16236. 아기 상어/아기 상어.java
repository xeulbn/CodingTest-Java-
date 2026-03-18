import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int n; //공간 크기 (가로,세로)
    public static int m; // 물고기 마리수
    public static int[][] map;
    public static int babySharkSize;
    public static int babyX;
    public static int babyY;
    public static int eatCnt;
    public static int[] dx = {-1,0,0,1};
    public static int[] dy = {0,-1,1,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        //초기 아기상어 크기 2
        babySharkSize=2;
        eatCnt=0;
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    babyX=i;
                    babyY=j;
                    map[i][j]=0;
                }
            }
        }
        
        int answer =0;
        while(true){
            int dist = bfs(babyX,babyY);
            if(dist==-1){
                break;
            }
            answer+=dist;
        }
        System.out.println(answer);
    }

    public static int bfs(int startX, int startY){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        
        q.offer(new int[]{startX,startY,0});
        visited[startX][startY]=true;
        
        List<int[]> fishes = new ArrayList<>();

        int minDist= Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currDist= curr[2];
            
            if(currDist>=minDist){
                break;
            }

            for(int i=0;i<4;i++){
                int nextX = currX+dx[i];
                int nextY = currY+dy[i];
                
                //map벽에 의해 막히는 경우
                if(nextX<0||nextX>=n||nextY<0||nextY>=n){
                    continue;
                }
                if(visited[nextX][nextY]){
                    continue;
                }
                //자기보다 큰 물고기에 막히는 경우
                if(map[nextX][nextY]>babySharkSize){
                    continue;
                }

                visited[nextX][nextY]=true;
                int nextDist= currDist+1;
                
                //먹을 수 있는 경우
                if(map[nextX][nextY]!=0&& map[nextX][nextY]<babySharkSize){
                    fishes.add(new int[]{nextX,nextY,nextDist});
                    minDist=nextDist;
                }
                q.offer(new int[]{nextX,nextY,nextDist});
            }
            
        }
        
        if(fishes.isEmpty()){
            return -1;
        }

        //물고기 정렬 : 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기 아니면 왼쪽 조건때문
        fishes.sort((a,b)->{
            if(a[0]!= b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });

        int[] target = fishes.get(0);
        babyX = target[0];
        babyY = target[1];

        map[babyX][babyY]=0; //먹으면 없어지니까
        eatCnt+=1;

        if(eatCnt==babySharkSize){
            babySharkSize+=1;
            eatCnt=0;
        }
        
        return target[2];
        
    }
}