import java.util.*;

class Solution {
    public int zeroSum=0;

    public int[] solution(String s) {
        String[] split = s.split("");
        int answer=0;
        
        while(split.length!=1){
            split=transferTo(split);
            answer++;
        }
        
        int[] answerArr={answer,zeroSum};
        
        
        return answerArr;
    }
    
    public String[] transferTo(String[] splitString){
        List<String> afterZero=new ArrayList<>();
        for(int i=0;i<splitString.length;i++){
            if(splitString[i].equals("1")){
                afterZero.add(splitString[i]);
            }else{
                zeroSum++;
            }
        }
        int size=afterZero.size();
        String binary= Integer.toBinaryString(size);
        
        return binary.split("");
    }
}