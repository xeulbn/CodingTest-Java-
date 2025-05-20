import java.util.*;

class Solution {
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        int people=1;
        
        int size= stones.length;
        int index=0;
        
        while(people!=0){
            int go = checkCango(stones,k,index);
            answer=people;
            if(go==0){
                people=0;
                break;
            }
            stones[index]=stones[index]-1;
            
            index+=go;
            if(index>=size){
                people++;
                index=0;
            }
        }
        
        return answer;
    }
    
    public static int checkCango(int[] stones ,int limit,int now){
        int noCnt=0;
        int indexCnt=0;
        
        for(int i=1;i<=limit;i++){
            if(stones[now+i]==0){
                noCnt++;
            }else{
                indexCnt=i;
                break;
            }
        }
        
        if(indexCnt==limit){
            return 0;
        }else{
            return indexCnt;
        }
    }
}