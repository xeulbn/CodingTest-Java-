import java. util. *;

class Solution {
    public int solution(String s) {
        int curMinValue = s.length();
        
        for(int i=1;i<=s.length()/2;i++){
            int pressedSize = calculatePressedSize(s,i);
            curMinValue = Math.min(curMinValue,pressedSize);
        }
        
        return curMinValue;
    }

    private int calculatePressedSize(String str, int size){
        StringBuilder result = new StringBuilder();
        String prev = str.substring(0,size);
        int count = 1;
        
        for(int start=size;start<str.length();start+=size){
            int end = Math.min(start+size,str.length());
            String current = str.substring(start,end);
            
            if(prev.equals(current)){
                count +=1;
            }else{
                if(count>=2){
                    result.append(count);
                }
                result.append(prev);
                prev = current;
                count=1;
            }
        }
        if(count>=2){
            result.append(count);
        }
        result.append(prev);
        
        return result.length();
    }
}