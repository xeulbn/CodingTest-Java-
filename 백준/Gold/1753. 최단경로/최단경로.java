import java.util.*;
import java.io.*;

public class Main {

    public static int v;
    public static int e;
    public static int k;
    public static int[] dist;
    public static List<List<Node>> map;

    public static class Node{
        int index;
        int weight;
        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        dist = new int[v + 1];

        map = new ArrayList<>();
        for(int i = 0; i <= v; i++){
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map.get(start).add(new Node(end, weight));
        }

        dijkstra(k);

        for(int i = 1; i <= v; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Node(start, 0));
        boolean[] visited = new boolean[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int curr = now.index;

            if(visited[curr]) continue;
            visited[curr] = true;

            for(Node next : map.get(curr)){
                if(dist[next.index] > dist[curr] + next.weight){
                    dist[next.index] = dist[curr] + next.weight;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
}
