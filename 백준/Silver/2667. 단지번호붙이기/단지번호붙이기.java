import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};

    static int[] apt = new int[25*25];
    static int aptNum=0;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            String s= st.nextToken();
            for(int j=0;j<n;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==1&&!visited[i][j]) {
                    aptNum++;
                    bfs(i,j);
                }
            }
        }

        Arrays.sort(apt);
        System.out.println(aptNum);

        for(int i=0;i<apt.length;i++){
            if(apt[i]==0)
                continue;
            else{
                System.out.println(apt[i]);
            }
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        apt[aptNum]++;

        while(!queue.isEmpty()){

            int nowX=queue.peek()[0];
            int nowY=queue.peek()[1];
            queue.poll();

            for(int i=0;i<4;i++){
                int nextX=nowX+dx[i];
                int nextY=nowY+dy[i];

                if(nextX>=0&& nextX<n&&nextY>=0&& nextY<n){
                    if(map[nextX][nextY]==1&&!visited[nextX][nextY]){
                        queue.add(new int[]{nextX,nextY});
                        visited[nextX][nextY] = true;
                        apt[aptNum]++;
                    }
                }
            }
        }
    }
}
