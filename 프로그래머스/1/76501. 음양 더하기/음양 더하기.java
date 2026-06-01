import java.util.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        int index=0;
        for(boolean a : signs){
            if(a==true){
                index+=1;
                continue;
            }
            
            if(a==false){
                absolutes[index]=absolutes[index]*(-1);
                index+=1;
            }
        }
        
        for(int number : absolutes){
            answer+=number;
        }
        
        return answer;
    }
}