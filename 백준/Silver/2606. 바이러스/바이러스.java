import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int n;
    public static int connect;
    public static List<List<Integer>> network;
    public static boolean[] visited;
    public static int answer = 0;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        connect=Integer.parseInt(st.nextToken());

        network=new ArrayList<>();
        for(int i=0;i<=n;i++){
            network.add(new ArrayList<>());
        }

        for(int i=0;i<connect;i++){
            st=new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            network.get(node1).add(node2);
            network.get(node2).add(node1);
        }

        visited=new boolean[n+1];

        bfs(1);
        System.out.println(answer-1);
    }

    public static void bfs(int start){
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(start);
        visited[start]=true;
        
        while(!q.isEmpty()){
            int current= q.poll();
            answer++;

            for(int computer : network.get(current)){
                if(!visited[computer]){
                    q.offer(computer);
                    visited[computer]=true;
                }
            }
        }
        
    }
    

}