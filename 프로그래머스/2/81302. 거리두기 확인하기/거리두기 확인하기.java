import java.util.*;

class Solution {
    
    public static int[][] directions = {
        {0,1},{1,0},{0,2},{2,0},{1,-1},{1,1}
};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0;i<places.length;i++){
            answer[i]=isSafe(places[i]);
        }
        
        return answer;
    }
    
    public int isSafe(String[] room){
        
        for(int xIndex=0;xIndex<room.length;xIndex++){
            for(int yIndex=0;yIndex<room[xIndex].length();yIndex++){
                
                if(room[xIndex].charAt(yIndex) != 'P'){
                    continue;
                }
                
                for(int i=0;i<directions.length;i++){
                    int nxIndex=xIndex+directions[i][0];
                    int nyIndex=yIndex+directions[i][1];
                    
                    if(nxIndex<0||nxIndex>=room.length||nyIndex<0||nyIndex>=room[nxIndex].length()){
                        continue;
                    }
                    
                    if(room[nxIndex].charAt(nyIndex) != 'P'){
                        continue;
                    }
                    
                    int distance = Math.abs(xIndex-nxIndex)+Math.abs(yIndex-nyIndex);
                    
                    if(distance==1){
                        return 0;
                    }
                    
                    if(xIndex== nxIndex || yIndex== nyIndex){
                        int middleX = (xIndex+nxIndex)/2;
                        int middleY = (yIndex+nyIndex)/2;
                        
                        if(room[middleX].charAt(middleY)!='X'){
                            return 0;
                        }
                    }else{
                        if(room[xIndex].charAt(nyIndex)!='X'||
                          room[nxIndex].charAt(yIndex)!='X'){
                            return 0;
                        }
                    }
                    
                }
            }
        }
        
        return 1;
    }
    
    
}