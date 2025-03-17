import java.util.*;

class Solution {
    
    public int solution(String[] board) {
        
        int zeroCnt =0;
        int xCnt=0;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='O'){
                    zeroCnt++;
                }else if(board[i].charAt(j)=='X'){
                    xCnt++;
                }
            }
        }
        if(zeroCnt<xCnt||zeroCnt-xCnt>1){
            return 0;
        }
        
        if(bingo('O',board)){
            if(zeroCnt==xCnt){
                return 0;
            }
        }
        
        if(bingo('X',board)){
            if(zeroCnt>xCnt){
                return 0;
            }
        }
        
        
        return 1;
    }
    
    public boolean bingo(char c,String[] board){
        for(int i=0;i<3;i++){
            if(board[i].charAt(0)==c&&board[i].charAt(1)==c&&board[i].charAt(2)==c){
                return true;
            }
        }
        
        for(int i=0;i<3;i++){
            if(board[0].charAt(i)==c&&board[1].charAt(i)==c&&board[2].charAt(i)==c){
                return true;
            }
        }
        
        if(board[0].charAt(0)==c&&board[1].charAt(1)==c&&board[2].charAt(2)==c){
            return true;
        }
        
        if(board[2].charAt(0)==c&&board[1].charAt(1)==c&&board[0].charAt(2)==c){
            return true;
        }
        return false;
    }
}