import java.util.*;

class Solution {
    public String solution(String p) {
        if(p.isEmpty()){
            return "";
        }
        
        int index = sliceIndex(p);
        String u = p.substring(0,index+1);
        String v = p.substring(index+1);
        
        if (isCorrect(u)) {
            return u + solution(v);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");
        
        String sliced= u.substring(1, u.length() - 1);
        sb.append(reverse(sliced));
        
        return sb.toString();
        
    }
    
    private int sliceIndex(String str){
        int openCnt=0;
        int closeCnt=0;
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                openCnt+=1;
            }else if(str.charAt(i)==')'){
                closeCnt+=1;
            }
            
            if(openCnt==closeCnt){
                return i;
            }
        }
        return str.length()-1;
    }
    
    private boolean isCorrect(String str) {
    int count = 0;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
    
    private String reverse(String str){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }
}