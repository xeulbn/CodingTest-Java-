import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n>s){
            return new int[]{-1};
        }
        
        int bigOne=s/n;
        int smallOne=s%n;
        
        for(int i=0;i<n;i++){
            if(i>=n-smallOne){
                answer[i]=bigOne+1;
            }else{
                answer[i]=bigOne;
            }
        }
        
        return answer;
    }
}