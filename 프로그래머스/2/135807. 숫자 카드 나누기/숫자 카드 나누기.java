import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        int answer=0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA=arrayA[0];
        int gcdB=arrayB[0];
        
        for(int i=1;i<arrayA.length;i++){
            gcdA=gcd(arrayA[i],gcdA);
            gcdB=gcd(arrayB[i],gcdB);
        }
        
        if(!divide(arrayB,gcdA)){
            answer=Math.max(answer,gcdA);
        }
        
        if(!divide(arrayA,gcdB)){
            answer=Math.max(answer,gcdB);
        }
        
        return answer;
    }
    
    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
    
    public static boolean divide(int[]array, int gcd){
        for(int i=0;i<array.length;i++){
            if(array[i]%gcd==0){
                return true;
            }
        }
        return false;
    }
}