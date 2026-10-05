import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            answer[i]=comparePrices(i,prices);
        }
        return answer;
    }
    
    private int comparePrices(int start, int[] prices){
        for(int i=start+1;i<prices.length;i++){
            if(prices[start]>prices[i]){
                return i-start;
            }
        }
        return prices.length-1-start;
    }
}