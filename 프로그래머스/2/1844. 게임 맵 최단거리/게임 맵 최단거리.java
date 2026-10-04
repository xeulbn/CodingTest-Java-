import java.util.*;

class Solution {
    // 0:벽, 1:벽x
    private static boolean[][] visited;
    private static int[][] distance;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int minGoValue = Integer.MAX_VALUE;
        visited = new boolean[maps.length][maps[0].length];
        distance = new int[maps.length][maps[0].length];
        for (int[] arr : distance) {
            Arrays.fill(arr, -1);
        }
        bfs(maps);
        return distance[maps.length-1][maps[0].length-1];
    }
    
    private void bfs(int[][] maps){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0]=true;
        distance[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] currNode = q.poll();
            int currX = currNode[0];
            int currY = currNode[1];
            
            for(int i=0;i<4;i++){
                int nextX = currX+dx[i];
                int nextY = currY+dy[i];
                
                if(nextX>=maps.length||nextX<0||nextY<0||nextY>=maps[0].length){
                    continue;
                }
                if(maps[nextX][nextY]==0 || visited[nextX][nextY]){
                    continue;
                }
                q.offer(new int[]{nextX,nextY});
                distance[nextX][nextY]= distance[currX][currY]+1;
                visited[nextX][nextY]=true;
            }
        }
        
    }
}