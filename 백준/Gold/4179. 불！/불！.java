import java.io.*;
import java.util.*;

public class Main {

    static int r;
    static int c;
    static int[][] map;
    static int[][] visited;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static Queue<int[]> jihun = new LinkedList<>();
    public static Queue<int[]> fire = new LinkedList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        map=new int[r][c];
        visited=new int[r][c];

        for (int i=0;i<r;i++){
            String str=br.readLine();
            for(int j=0;j<c;j++){
                char c= str.charAt(j);
                if(c=='#'){
                    map[i][j]=-1;
                } else if(c=='J'){
                    jihun.add(new int[]{i,j});
                    visited[i][j]=1;
                }else if(c=='F'){
                    fire.add(new int[]{i,j});
                    map[i][j]=2;
                }
            }
        }

        bfs();
        System.out.println("IMPOSSIBLE");
    }

    public static void bfs() {
        int time=0;

        while(!jihun.isEmpty()){
            int fireLen=fire.size();
            for(int i=0;i<fireLen;i++){
                int[] fireArr=fire.poll();
                for(int j=0;j<4;j++){
                    int nx= fireArr[0]+dx[j];
                    int ny= fireArr[1]+dy[j];

                    if(!isIn(nx,ny)|| map[nx][ny]!=0){
                        continue;
                    }

                    map[nx][ny]=2;
                    fire.add(new int[]{nx,ny});
                }
            }
            int jihunLen=jihun.size();
            for(int i=0;i<jihunLen;i++){
                int[]jihunArr=jihun.poll();
                for(int j=0;j<4;j++){
                    int nx= jihunArr[0]+dx[j];
                    int ny= jihunArr[1]+dy[j];

                    if(!isIn(nx,ny)){
                        System.out.println(time+1);
                        System.exit(0);
                    }

                    if(map[nx][ny]==0&&visited[nx][ny]==0){
                        visited[nx][ny]=1;
                        jihun.add(new int[]{nx,ny});
                    }
                }
            }
            time++;
        }
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}