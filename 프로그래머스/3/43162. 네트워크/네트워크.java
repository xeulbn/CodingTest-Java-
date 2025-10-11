import java.util.*;

class Solution {
    public static boolean[] visited;
    
    public int solution(int n, int[][] computers) {

        int answer = 0;
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                bfs(i,computers,n);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start, int[][] computers, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start]=true;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int i=0;i<n;i++){
                if(visited[i]==false&&computers[now][i]==1){
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
    }

    
}

