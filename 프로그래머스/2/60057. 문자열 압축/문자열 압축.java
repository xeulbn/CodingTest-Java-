import java. util. *;

class Solution {
    public int solution(String s) {
        int minValue = s.length();
        
        for(int i=1;i<=s.length()/2;i++){
            int pressedSize = calculatePressedSize(s,i);
            minValue=Math.min(pressedSize,minValue);
        }
        
        return minValue;
    }
    
    private int calculatePressedSize(String str, int windowSize){
        StringBuilder sb = new StringBuilder();
        String prev = str.substring(0,windowSize);
        
        int sameCnt =1;
        for(int i=windowSize;i<str.length();i+=windowSize){
            int end = Math.min(i + windowSize, str.length());
            String curr = str.substring(i,end);
            if(curr.equals(prev)){
                sameCnt+=1;
            }else{
                if(sameCnt!=1){
                    sb.append(sameCnt);
                }
                sb.append(prev);
                prev = curr;
                sameCnt=1;
            }
        }
        
        if(sameCnt!=1){
            sb.append(sameCnt);
        }
        sb.append(prev);
        return sb.toString().length();
    }
}