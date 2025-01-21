import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left =Arrays.stream(diffs).min().orElse(1);
        int right = Arrays.stream(diffs).max().orElse(1);
        
        while(left<=right){
            int currentLevel= (left+right)/2;
            
            long currentTime=0;
            
            for(int i=0;i<diffs.length;i++){
                if(diffs[i]<=currentLevel){
                    currentTime+=times[i];
                }else{
                    int levelDiff = diffs[i]-currentLevel;
                    
                    if(i==0){
                        currentTime+=(long)times[i]*levelDiff+times[i];
                    }else{
                        currentTime+=(times[i-1]+times[i])*levelDiff+times[i];
                    }
                }
                
                if (currentTime > limit) {
                    break;
                }
            }
            
            if(currentTime<=limit){
                answer= currentLevel;
                right = currentLevel-1;
            }else{
                left=currentLevel+1;
                
                
            }
            
        }
        
        return answer;
    }
}