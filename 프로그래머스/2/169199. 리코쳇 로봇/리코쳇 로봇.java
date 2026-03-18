import java.util.*;

class Solution {
    
    public String[][] gameBoard;
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    public int row;
    public int col;
    
    public int solution(String[] board) {
        int answer = 0;
        row = board.length;
        col = board[0].length();
        gameBoard = new String[row][col];
        
        for(int i=0;i<row;i++){
            gameBoard[i] = board[i].split("");
        }
        
        int startX =0;
        int startY = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(gameBoard[i][j].equals("R")){
                    startX=i;
                    startY=j;
                    break;
                }
            }
        }
        
        answer=move(startX,startY);
        
        
        return answer;
    }
    
    public int move(int x,int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y,0});
        boolean[][] visited = new boolean[row][col];
        visited[x][y]=true;
        
        int returnValue =0;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currDist = curr[2];
            
            if(gameBoard[currX][currY].equals("G")){
                return currDist;
            }
            
            for(int i=0;i<4;i++){
                int nextX = currX;
                int nextY = currY;
                
                while(true){

                    int tempx = nextX + dx[i];
                    int tempy = nextY + dy[i];
                    
                    if(tempx>=row||tempx<0||tempy>=col||tempy<0||gameBoard[tempx][tempy].equals("D")){
                        break;
                    }
                    
                    nextX = tempx;
                    nextY = tempy;
                    
                }
                
                if(!visited[nextX][nextY]){
                    visited[nextX][nextY]=true;
                    q.offer(new int[]{nextX, nextY, currDist + 1});
                }
            }
        }
        
        return -1;
    }
}