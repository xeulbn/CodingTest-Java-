import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String num = Integer.toString(n,k);
        String[] temp = num.split("0+");
        
        for(String tmp : temp){
            long x = Long.parseLong(tmp);
            
            if(isPrime(x)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num){
        if(num<2){
            return false;
        }
        if(num==2){
            return true;
        }
        if(num%2==0){
            return false;
        }
        
        long s = (long)Math.sqrt(num);
        
        for(long l=3;l<=s;l++){
            if(num%l==0){
                return false;
            }
        }
        return true;
    }
}