import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int BOARD_ROW = 5;
    public static int BOARD_COL = 5;
    public static List<int[]> starIndex;
    public static int starCnt;
    public static int[] selected;
    public static int minDist;
    public static boolean[] used;
    
    public static char[][] board;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[BOARD_ROW][BOARD_COL];
        starIndex= new ArrayList<>();
        
        for(int i=0;i<BOARD_ROW;i++){
            String line = br.readLine();
            for(int j=0;j<BOARD_COL;j++){
                board[i][j]=line.charAt(j);
                if(board[i][j]=='*'){
                    starIndex.add(new int[]{i,j});
                }
            }
        }

        starCnt = starIndex.size();
        selected = new int[starCnt];
        comb(0, 0);
        System.out.println(answer);
        
    }

    public static void comb(int start, int depth){
        if(depth==starCnt){
            List<int[]> stars = new ArrayList<>();

            for(int i=0;i<starCnt;i++){
                int num = selected[i];
                int x= num/5;
                int y = num%5;

                stars.add(new int[]{x,y});                
            }
            if(isLinked(stars)){
                int cost = calcMinDistance(stars);
                answer= Math.min(answer,cost);
            }
            return;
        }

        for(int i=start;i<(BOARD_ROW * BOARD_COL);i++){
            selected[depth] = i;
            comb(i+1, depth+1);
        }
        
    }

    public static boolean isLinked(List<int[]> cells){
        boolean[][] picked = new boolean[BOARD_ROW][BOARD_COL];
        
        for(int[] cell : cells){
            picked[cell[0]][cell[1]]=true;
        }

        Queue<int[]> q= new ArrayDeque<>();
        boolean[][] visited = new boolean[BOARD_ROW][BOARD_COL];
        int[] start = cells.get(0);
        q.offer(new int[]{start[0],start[1]});
        visited[start[0]][start[1]] = true;

        int count=1;
        while(!q.isEmpty()){
            int[] node =q.poll();

            for(int dir=0;dir<4;dir++){
                int nx = node[0]+dx[dir];
                int ny = node[1]+dy[dir];

                if(nx<0||nx>=BOARD_ROW||ny<0||ny>=BOARD_COL){
                    continue;
                }
                if(!picked[nx][ny] || visited[nx][ny]){
                    continue;
                }

                q.offer(new int[]{nx,ny});
                count++;
                visited[nx][ny]=true;
            }
        }

        return count == cells.size();
    }


    public static int calcMinDistance(List<int[]> cells){
        used = new boolean[starCnt];
        minDist = Integer.MAX_VALUE;
        perm(0, cells, 0);
        return minDist;
    }

    public static void perm(int depth, List<int[]> cells,int sum){
        if(depth == starCnt){
            minDist = Math.min(minDist, sum);
            return;
        }

        if(sum >= minDist){
            return;
        }

        for(int i=0; i<starCnt; i++){
            if(used[i]) {
                continue;
            }

            used[i] = true;

            int dist = Math.abs(starIndex.get(depth)[0] - cells.get(i)[0])
                     + Math.abs(starIndex.get(depth)[1] - cells.get(i)[1]);

            perm(depth + 1, cells, sum + dist);

            used[i] = false;
        }
    }
    
}