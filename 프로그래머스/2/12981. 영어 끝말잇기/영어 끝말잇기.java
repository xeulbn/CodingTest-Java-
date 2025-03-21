import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[]answer={0,0};
        ArrayList<String> listWords= new ArrayList<>();
        
        for(int i=0;i<words.length;i++){
            if(i>0&& words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || listWords.contains(words[i])){
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
            
            listWords.add(words[i]);
        }
        
        return answer;
    }
}