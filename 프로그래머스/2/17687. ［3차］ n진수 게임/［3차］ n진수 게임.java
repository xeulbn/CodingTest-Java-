import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        int wantCnt =t*m;
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        int tempCnt=0;
        int count=0;
        while(tempCnt<wantCnt){
            String full = changeFull(count,n);
            int fullCount = full.length();
            
            tempCnt=tempCnt+fullCount;
            convert.append(full);
            count=count+1;
        }
        
        String temp = convert.toString();
        int check=0;
        
        for(int i=0;i<temp.length();i++){
            if(check==t)
                break;
            
            if(i%m==p-1){
                answer.append(temp.charAt(i));
                check=check+1;
            }
        }
        
        return answer.toString().toUpperCase();
    }
    
    public String changeFull(int num,int decimal){
        return Integer.toString(num,decimal);
    }
}