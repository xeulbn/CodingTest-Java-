import java.io.*;
import java.util.*;

public class Main {

    static int l;
    static int r;
    static int c;

    static char map[][][];
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 0, 1, 0, -1};
    static int[] dz = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start_x=0, start_y=0, start_z=0;
            int end_x=0, end_y=0, end_z=0;

            l=Integer.parseInt(st.nextToken());
            r=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());

            if(l==0&&r==0&&c==0) {
                break;
            }

            map=new char[l][r][c];
            visited=new boolean[l][r][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String temp = br.readLine();
                    for (int k = 0; k < c; k++) {
                        if (temp.charAt(k) == 'S') {
                            start_z = i;
                            start_x = j;
                            start_y = k;
                        }
                        if (temp.charAt(k) == 'E') {
                            end_z = i;
                            end_x = j;
                            end_y = k;
                        }
                        map[i][j][k] = temp.charAt(k);
                    }
                }
                br.readLine();
            }

            int result = bfs(start_z, start_x, start_y, end_z, end_x, end_y);

            if (result == -1)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in " + result + " minute(s).");

        }
    }

    static int bfs(int start_z,int start_x, int start_y, int end_z,int end_x,int end_y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start_z,start_x,start_y});
        visited[start_z][start_x][start_y] = true;

        int minutes=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] current = queue.poll();
                int z= current[0];
                int x= current[1];
                int y= current[2];

                if(z==end_z&&x==end_x&&y==end_y){
                    return minutes;
                }

                for(int j=0;j<6;j++){
                    int nz=z+dz[j];
                    int nx=x+dx[j];
                    int ny=y+dy[j];

                    if(nz<0||nx<0||ny<0||nz>=l||nx>=r||ny >= c){
                        continue;
                    }

                    if(map[nz][nx][ny]=='#'||visited[nz][nx][ny]){
                        continue;
                    }

                    queue.offer(new int[]{nz,nx,ny});
                    visited[nz][nx][ny] = true;
                }
            }
            minutes++;
        }
        return -1;
    }
}
