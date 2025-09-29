import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int k;
    public static int[] visited;

    public static class Node{
        int index;
        int time;
        Node(int index, int time){
            this.index = index;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());

        visited= new int[100001];

        bfs(n,1);
        System.out.println(visited[k]-1);
    }

    public static void bfs(int x, int time){
        Queue<Node> queue= new LinkedList<>();
        queue.add(new Node(x,time));
        visited[x]=1;

        while(!queue.isEmpty()){
            Node now= queue.poll();

            if(now.index-1>=0 && now.index-1<=100000){
                if(visited[now.index-1]==0|| visited[now.index-1]>now.time+1){
                    visited[now.index-1]=now.time+1;
                    queue.add(new Node(now.index-1,now.time+1));
                }
            }

            if(now.index+1>=0 && now.index+1<=100000){
                if(visited[now.index+1]==0|| visited[now.index+1]>now.time+1){
                    visited[now.index+1]=now.time+1;
                    queue.add(new Node(now.index+1,now.time+1));
                }
            }

            if(now.index*2>=0 && now.index*2<=100000){
                if(visited[now.index*2]==0|| visited[now.index*2]>now.time){
                    visited[now.index*2]=now.time;
                    queue.add(new Node(now.index*2,now.time));
                }
            }
        }
    }
}
