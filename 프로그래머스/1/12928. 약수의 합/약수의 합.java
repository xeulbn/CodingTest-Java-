class Solution {
    public int solution(int n) {
        int answer = 0;
        int div = 1;
        
        while(n>0&&div<=n){
            if(n%div==0){
                answer+=div;
            }
            div+=1;
        }
        
        return answer;
    }
}