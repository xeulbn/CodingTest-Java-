import java.util.*;

class Solution {
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    
    
    public int solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        int answer= -1;
        
        int[] start= new int[3];
        int[] lever = new int[3];
        int[]end = new int[3];
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j)=='O'){
                    map[i][j]=1;
                }else if(maps[i].charAt(j)=='L'){
                    lever[0]=i;
                    lever[1]=j;
                    map[i][j]=1;
                }else if(maps[i].charAt(j)=='S'){
                    start[0]=i;
                    start[1]=j;
                    map[i][j]=1;
                }else if(maps[i].charAt(j)=='E'){
                    map[i][j]=1;
                    end[0]=i;
                    end[1]=j;
                    
                }
            }
        }
        answer= bfs(start,lever);
        if(answer>-1){
            visited = new boolean[maps.length][maps[0].length()];
            int tmp = bfs(lever,end);
            if(tmp==-1){
                answer=-1;
            }else{
                answer+=tmp;
            }
        }
        
        return answer;
    }
    
    public int bfs(int[] start, int[] destination){
        Queue<int[]> queue = new LinkedList<>();
        

        queue.add(start);
        visited[start[0]][start[1]]=true;
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0]==destination[0]&&tmp[1]==destination[1]){
                return tmp[2];
            }
            for(int i=0;i<4;i++){
                int nx= tmp[0]+dx[i];
                int ny= tmp[1]+dy[i];
                if(nx>=0&&nx<map.length&&ny>=0&&ny<map[0].length
                  && map[nx][ny]>0&&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx,ny,tmp[2]+1});
                }
            }
        }
        return -1;
    }
}