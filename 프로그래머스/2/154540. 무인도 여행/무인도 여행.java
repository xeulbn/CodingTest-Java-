import java.util.*;

class Solution {
    
    public static int [][]map;
    public static boolean[][] visited;
    public static int day=0;
    public static int[] upDown = {1, -1, 0, 0};
    public static int[] leftRight = {0, 0, 1, -1};
    public static int X;
    public static int Y;
    
    
    public int[] solution(String[] maps) {
        
        X= maps.length;
        Y=maps[0].length();
        
        map=new int[X][Y];
        visited= new boolean[X][Y];
        
        for(int i=0;i<maps.length;i++){
            char[] temp = maps[i].toCharArray();
            for(int j=0;j<maps[0].length();j++){
                if(temp[j]=='X'){
                    map[i][j]=0;
                }else{
                    map[i][j]=temp[j]-'0';
                }
            }
        }
        
        List<Integer> days = new ArrayList<>();
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(!visited[i][j]&&map[i][j]>0){
                    dfs(map,visited,i,j);
                    System.out.println(day);
                    days.add(day);
                    day=0;
                }
            }
        }
        
        if(days.isEmpty()) {
             return new int[]{-1};
        }
        
        Collections.sort(days);
        
        int[] answer = new int[days.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = days.get(i);
        }
        
        
        return answer;
    }
    
    public static void dfs(int[][]map, boolean[][] visited , int x, int y){
        day+=map[x][y];
        visited[x][y]=true;
        
        for(int i = 0; i < 4; i++) {
            int newX = x + upDown[i];
            int newY = y + leftRight[i];

            if(newX < 0 || newY < 0 || newX >= X || newY >=Y) {
                continue;
            }

            if(!visited[newX][newY] && map[newX][newY] > 0) {
                dfs(map, visited, newX, newY);
            }
        }
        
        
    }
}