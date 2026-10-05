import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int functionCnt = progresses.length;
        int[] takeTime = new int[functionCnt];
        List<Integer> returnValue = new ArrayList<>();
        
        for(int i=0;i<functionCnt;i++){
            takeTime[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int sameCnt= 1;
        int maxTakeTime = takeTime[0];
        for(int i=1;i<functionCnt;i++){
            if (takeTime[i] <= maxTakeTime) {
                sameCnt+=1;
            } else {
                returnValue.add(sameCnt);
                sameCnt=1;
                maxTakeTime = takeTime[i];
            }
        }
        
        returnValue.add(sameCnt);
        
        return returnValue.stream().mapToInt(i->i).toArray();
        
    }
}