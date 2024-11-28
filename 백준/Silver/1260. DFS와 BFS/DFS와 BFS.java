import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int v;
    public static int[][] arr;
    public static boolean[] visited;
    public static StringBuilder sb= new StringBuilder();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        v=Integer.parseInt(st.nextToken());

        arr= new int[n+1][n+1];
        visited= new boolean[n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            arr[x][y]=1;
            arr[y][x]=1;
        }

        dfs(v);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int v){
        sb.append(v+" ");
        visited[v]=true;

        for(int i=1;i<n+1;i++){
            if(i!=v&&visited[i]==false&&arr[v][i]==1){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        for(int i=0;i<n+1;i++){
            visited[i]=false;
        }

        Queue<Integer> queue= new LinkedList<>();
        queue.add(v);
        visited[v]=true;

        while(!queue.isEmpty()){
            int num= queue.poll();
            sb.append(num+" ");

            for(int i=1;i<n+1;i++){
                if(i!=num&&visited[i]==false&&arr[num][i]==1){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        sb.append("\n");
    }
}
