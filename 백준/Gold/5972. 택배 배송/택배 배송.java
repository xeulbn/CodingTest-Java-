import java.io.*;
import java.util.*;


public class Main {

    public static int n;
    public static int m;
    public static List<List<Node>> map;
    public static int[] minimum;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new ArrayList<>();
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            int cost= Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end,cost));
            map.get(end).add(new Node(start, cost));
        }


        Dijkstra(1);
        System.out.println(minimum[n]);


    }

    public static class Node{
        int end;
        int cost;

        Node(int end, int cost) {
           this.end=end;
           this.cost=cost;
        }
    }

    public static void Dijkstra(int start){
        PriorityQueue<Node> pq= new PriorityQueue<>(Comparator.comparingInt(o->o.cost));
        minimum=new int[n+1];
        Arrays.fill(minimum,Integer.MAX_VALUE);
        minimum[start]=0;

        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowNode=now.end;
            int nowCost=now.cost;

            if(minimum[nowNode]<nowCost){
                continue;
            }

            for(Node next:map.get(nowNode)){
                if(minimum[next.end]>nowCost+next.cost){
                    minimum[next.end]=nowCost+next.cost;
                    pq.add(new Node(next.end,minimum[next.end]));
                }
            }
        }
    }

}
