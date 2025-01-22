import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int size = routes.length;
        Queue<int[]>[] robot = new LinkedList[size];
        
        for(int i=0;i<size;i++){
            robot[i]=new LinkedList<>();
        }
        
        for(int i=0;i<size;i++){
            int[] point =points[routes[i][0]-1];
            int x=point[0];
            int y= point[1];
            robot[i].add(new int[]{x,y});
            
            for(int j=1;j<routes[i].length;j++){
                int[] next= points[routes[i][j]-1];
                int nx= next[0];
                int ny= next[1];
                
                int xp= nx-x;
                int yp =ny-y;
                
                while(xp!=0){
                    if(xp>0){
                        xp--;
                        x++;
                        robot[i].add(new int[]{x,y});
                    }else{
                        xp++;
                        x--;
                        robot[i].add(new int[]{x,y});
                    }
                }
                
                while(yp != 0){
                    if(yp>0){
                        yp--;
                        y++;
                        robot[i].add(new int[]{x,y});
                    }else{
                        yp++;
                        y--;
                        robot[i].add(new int[]{x,y});
                    }
                }
            }
        }
        
        int cnt=0;
        while(cnt!=size){
            int[][] map = new int[101][101];
            
            cnt=0;
            for(int i=0;i<size;i++){
                if(robot[i].isEmpty()){
                    cnt++;
                    continue;
                }
                
                int[] tmp = robot[i].poll();
                map[tmp[0]][tmp[1]]++;
            }
            for(int i=0;i<101;i++){
                for(int j=0;j<101;j++){
                    if(map[i][j]>1){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}