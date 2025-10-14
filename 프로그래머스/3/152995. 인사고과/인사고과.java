import java.util.*;

class Solution {
    public Map<Integer,Integer> scoreMap = new HashMap<>();
    
    
    public int solution(int[][] scores) {
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int wanhoScore = wanhoA+wanhoB;
        
        Arrays.sort(scores, (a,b) -> {
           if(a[0]==b[0]){
               return Integer.compare(a[1],b[1]);
           }
            return Integer.compare(b[0],a[0]);
        });
        
        int maxB = -1;
        int rank =1;
        
        for(int[] score : scores){
            int a = score[0];
            int b= score[1];
            
            if(wanhoA<a && wanhoB < b){
                return -1;
            }
            
            if(b<maxB){
                continue;
            }
            
            maxB = Math.max(maxB,b);
            if (a+b > wanhoScore){
                rank++;
            }
        }
        
        return rank;
    }
}