import java.io.*;
import java.util.*;

public class Main {

    static int m;
    static int n;
    static int k;
    static int[][] map;
    static boolean[][] visited;
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st= new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        map=new int[m][n];
        visited=new boolean[m][n];
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i<k;i++){
            st= new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for(int y=y1;y<y2;y++){
                for(int x=x1;x<x2;x++){
                    map[y][x]=1;
                }
            }
        }

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&map[i][j]==0){
                    int data = bfs(i,j);
                    list.add(data);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }

    public static int bfs(int x,int y){
        Queue<int[]> queue= new LinkedList<>();
        queue.offer((new int[]{x,y}));
        visited[x][y]=true;
        int cnt=1;

        while(!queue.isEmpty()){
            int[] data= queue.poll();
            int nowX=data[0];
            int nowY=data[1];

            for(int i=0;i<4;i++){
                int nextX=nowX+dx[i];
                int nextY=nowY+dy[i];

                if(nextX>=0&&nextX<m &&nextY>=0&&nextY<n){
                    if(!visited[nextX][nextY]&&map[nextX][nextY]==0){
                        visited[nextX][nextY]=true;
                        queue.offer(new int[]{nextX,nextY});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
