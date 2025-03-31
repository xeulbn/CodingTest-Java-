import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] nameArray = name.toCharArray();
        int index=0;
        int move= name.length()-1;
        int diff=0;
        
        for(int i=0; i<name.length();i++){
            answer+=Math.min(nameArray[i]-'A','Z'-nameArray[i]+1);
            index=i+1;
            while(index<name.length()&&nameArray[index]=='A'){
                index++;
            }
            
            move=Math.min(move,Math.min(i,name.length()-index)+i+name.length()-index);
        }
        
        answer+=move;
        return answer;
    }
}