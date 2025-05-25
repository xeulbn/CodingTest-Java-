import java.util.*;

class Solution {
    public static List<List<int[]>> map;
    public static boolean[] visited;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        map=new ArrayList<>();
        for(int i=0;i< n;i++){
            map.add(new ArrayList<>());
        }
        
        for(int i=0;i<costs.length;i++){
            int from= costs[i][0];
            int to = costs[i][1];
            int weight = costs[i][2];
            
            map.get(from).add(new int[]{to,weight});
            map.get(to).add(new int[]{from,weight});
        }
        
        visited=new boolean[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a-> a[1]));
        pq.offer(new int[] {0,0});
        int totalCost=0;
    
        while(!pq.isEmpty()){
            int[] current= pq.poll();
            int island=current[0];
            int cost= current[1];
            
            if(visited[island])
                continue;
            
            visited[island]=true;
            totalCost+=cost;
            
            for(int[]next:map.get(island)){
                if(!visited[next[0]]){
                    pq.offer(next);
                }
            }
        }
        
        
        return totalCost;
    }
}