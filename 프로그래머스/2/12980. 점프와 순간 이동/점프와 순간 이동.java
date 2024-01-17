import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
         if(n%2==0){
             while(n>1){
                 n=n/2;
                 if(n%2!=0){
                     answer++;
                     n=n-1;
                 }
             }
         } else{
             answer++;
             while(n>1){
                 n=n/2;
                 if(n%2!=0){
                     answer++;
                     n=n-1;
                 }
             }
         }
        return answer;
    }
}