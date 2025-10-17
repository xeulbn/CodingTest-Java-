import java.util.*;

public class Node{
    int x;
    int y;
    int dir;
    int cost;
    public Node(int x,int y,int dir, int cost){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.cost=cost;
    }
}

class Solution {
    
    public static boolean[][][] visit;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    
    public int solution(int[][] board) {
        int answer = bfs(board);
        return answer;
    }
    
    public int bfs(int[][] board){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,-1,0));
        
        visit = new boolean[board.length][board.length][4];
        
        
        int minCost=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            if(node.x == board.length-1 && node.y == board.length-1){
                minCost= Math.min(minCost,node.cost);
                continue;
            }
            
            for(int i=0;i<4;i++){
                int nextX =node.x+dx[i];
                int nextY=node.y+dy[i];
                int nextCost= node.cost;
                
                if(nextX<0 || nextY <0 || nextX>= board.length || nextY>= board.length|| 
                  board[nextX][nextY]==1){
                    continue;
                }
                
                if(i==node.dir||node.dir==-1){
                    nextCost+=100;
                }else{
                    nextCost+=600;
                }
                
                if(!visit[nextX][nextY][i] || board[nextX][nextY]>=nextCost){
                    queue.offer(new Node(nextX,nextY,i,nextCost));
                    visit[nextX][nextY][i]=true;
                    board[nextX][nextY]=nextCost;
                }
            }
        }
        return minCost;
    }
}