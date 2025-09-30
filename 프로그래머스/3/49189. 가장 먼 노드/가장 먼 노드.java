import java.util.*;

class Solution {
    
    List<List<Integer>> map = new ArrayList<>();
    
    public class Node{
        int index;
        int depth;
        
        public Node(int index, int depth){
            this.index=index;
            this.depth=depth;
        }
    }
    
    public int solution(int n, int[][] edge) {
        for(int i=0;i<=n;i++){
            map.add(new ArrayList<>());
        }
        
        for(int[] arr: edge){
            int node1 = arr[0];
            int node2 = arr[1];
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }
        
        boolean[] visited = new boolean[n+1];
        return bfs(map,n,visited);
    }
    
    public int bfs(List<List<Integer>> map, int n, boolean[] visited){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,0));
        visited[1]=true;
        int maxDepth=0;
        
        int answer =0;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int curIndex = now.index;
            int curDepth = now.depth;
            
            if(maxDepth == curDepth){
                answer++;
            }else if(maxDepth<curDepth){
                maxDepth=curDepth;
                answer=1;
            }
            
            for(int i=0;i<map.get(curIndex).size();i++){
                int next = map.get(curIndex).get(i);
                
                if(!visited[next]){
                    queue.add(new Node(next,curDepth+1));
                    visited[next]=true;
                }
            }
        }
        
        return answer;
        
    }
    
}