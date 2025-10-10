import java.util.*;

class Solution {
    
    public static List<List<Integer>> map;
    public static boolean[] visited;
    public static int[] answer;
    public static int[] dist;
    
    public class Node{
        int start;
        int distance;
        public Node(int start, int distance){
            this.start=start;
            this.distance=distance;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        answer = new int[sources.length];
        visited=new boolean[n+1];
        dist=new int[n+1];
        Arrays.fill(dist,-1);
        
        map = new ArrayList<>();
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
        }
        
        for(int i=0;i<roads.length;i++){
            map.get(roads[i][0]).add(roads[i][1]);
            map.get(roads[i][1]).add(roads[i][0]);
        }
        
        bfs(sources,destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
    public void bfs(int[] start, int dest){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(dest,0));
        
        visited[dest]=true;
        dist[dest]=0;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int cur = node.start;
            int curDist= node.distance;
            
            for(int next:map.get(cur)){
                if(!visited[next]){
                    visited[next]=true;
                    dist[next]=curDist+1;
                    queue.offer(new Node(next,curDist+1));
                }
            }
        }
    }
    
}