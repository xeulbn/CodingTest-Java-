import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, D;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;

    static class Node{
        int node;
        int weight;

        Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        distance= new int[D+1];
        for(int i=0;i<D+1;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[0]=0;

        for(int i=0;i<D+1;i++) {
            graph.add(new ArrayList<>());
        }


        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int a=  Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            int w =  Integer.parseInt(st.nextToken());

            if(b<=D){
                graph.get(a).add(new Node(b,w));
            }
        }
        for (int i = 0; i < D; i++) {
            graph.get(i).add(new Node(i + 1, 1));
        }

        dijkstra(0);
        System.out.println(distance[D]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.node;
            int currentWeight = current.weight;

            if (distance[currentNode] < currentWeight) {
                continue;
            }

            for (Node next : graph.get(currentNode)) {
                int newDistance = distance[currentNode] + next.weight;
                if (newDistance < distance[next.node]) {
                    distance[next.node] = newDistance;
                    pq.add(new Node(next.node, newDistance));
                }
            }
        }
    }
}
