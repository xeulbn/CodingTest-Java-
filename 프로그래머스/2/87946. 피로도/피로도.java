import java.util.*;

class Solution {
    
    private static int canGoMaxCnt = 0;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited= new boolean[dungeons.length];
        int answer = dfs(k,dungeons,0);
        return answer;
    }
    
    private int dfs(int currentP, int [][] map, int depth){
        canGoMaxCnt = Math.max(canGoMaxCnt, depth);
        
        for(int i=0;i<map.length;i++){
            if(visited[i]||currentP<map[i][0]){
                continue;
            }
            visited[i]=true;
            dfs(currentP-map[i][1],map,depth+1);
            visited[i]=false;
        }
        return canGoMaxCnt;
    }
}