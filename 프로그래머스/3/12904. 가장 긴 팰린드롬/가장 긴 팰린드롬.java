import java.util.*;

class Solution{
    
    //뒤집어도 똑같으면 팰린드롬....
    public int solution(String s){
        if(s.length()<=1){
            return s.length();
        }
        
        int answer =1;
        for(int center =0; center<s.length();center++){
            
            answer = Math.max(answer,expand(s,center,center));
            answer= Math.max(answer,expand(s,center,center+1));
        }
        
        return answer;
    }
    
    public int expand(String s, int left, int right){
        while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        
        return right-left-1;
    }
}