import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int[][] graph;
    public static boolean[] visit;
    public static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=1;i<m+1;i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            graph[x][y]=1;
            graph[y][x]=1;
        }

        for(int i=1;i<n+1;i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);

    }

    public static void dfs(int depth){
        visit[depth]=true;
        for(int i=1;i<n+1;i++){
            if(graph[depth][i]==1&&visit[i]==false){
                dfs(i);
            }
        }
    }
}
