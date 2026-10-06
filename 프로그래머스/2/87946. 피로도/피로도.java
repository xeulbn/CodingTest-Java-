import java.util.*;

class Solution {

    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited=new boolean[dungeons.length];
        int answer = dfs(k,dungeons,0);
        return answer;
    }
    
    private int dfs(int k, int[][] map,int visitCnt){
        int maxVisitCnt = visitCnt;
        for(int i=0;i<map.length;i++){
            if(visited[i]||map[i][0]>k){
                continue;
            }
            visited[i]=true;
            int result = dfs(k-map[i][1],map,visitCnt+1);
            maxVisitCnt = Math.max(maxVisitCnt, result);
            visited[i]=false;
        }
        return maxVisitCnt;
        
    }
}