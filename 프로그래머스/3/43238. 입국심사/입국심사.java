import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
        int judge= times.length;
        Arrays.sort(times);
        
        long low= 0;
        long high=times[judge-1]*(long)n;
            
        while(low<=high){
            long mid= (low+high)/2;
            long tmp=0;
            
            for(int i=0;i<judge;i++){
                tmp+=mid/times[i];
            }
            
            if(tmp<n){
                low=mid+1;
            }else{
                high=mid-1;
                answer=mid;
            }
        }
        
        
        return answer;
    }
}