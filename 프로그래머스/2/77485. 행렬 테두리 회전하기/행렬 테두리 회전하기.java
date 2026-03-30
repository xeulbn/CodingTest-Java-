import java.util.*;

class Solution {
    
    public int[][] origin;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        origin = new int[rows][columns];
        int index=1;
        for(int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                origin[i][j]=index;
                index+=1;
            }
        }
        
        int[] answer = new int[queries.length];
        for(int i=0;i<answer.length;i++){
            answer[i]= switching(queries[i]);
        }
        
        return answer;
    }
    
    public int switching(int[] position){
        int startX = position[0]-1;
        int startY = position[1]-1;
        int endX = position[2]-1;
        int endY = position[3]-1;
        
        int prev = origin[startX][startY];
        int min = prev;
        
        //우
        for(int i=startY+1;i<=endY;i++){
            int temp = origin[startX][i];
            origin[startX][i]=prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        
        //상
        for(int i=startX+1;i<=endX;i++){
            int temp = origin[i][endY];
            origin[i][endY]= prev;
            min = Math.min(prev,min);
            prev= temp;
        }
        
        //좌
        for(int i=endY-1;i>=startY;i--){
            int temp = origin[endX][i];
            origin[endX][i]=prev;
            min=Math.min(prev,min);
            prev= temp;
        }
        
        //우
        for(int i=endX-1;i>=startX;i--){
            int temp = origin[i][startY];
            origin[i][startY]=prev;
            min = Math.min(prev,min);
            prev=temp;
        }
        
        return min;
    }
}