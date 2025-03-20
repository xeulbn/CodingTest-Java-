import java. util. *;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int cnt=1;
        for(int i=1;i<=s.length()/2;i++){
            StringBuilder sb= new StringBuilder();
            String target = s.substring(0,i);
            for(int j=i;j<=s.length();j+=i){
                int endIndex = Math.min(j+i,s.length());
                String compare = s.substring(j,endIndex);
                if(target.equals(compare)){
                    cnt++;
                }else{
                    if(cnt>=2){
                        sb.append(cnt);
                    }
                    sb.append(target);
                    target= compare;
                    cnt=1;
                }
            }
            sb.append(target);
            answer=Math.min(answer,sb.length());
        }
        return answer;
    }
}