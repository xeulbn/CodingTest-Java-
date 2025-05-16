import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        List<Set<Integer>>dp = new ArrayList<>();        
        
        for(int i=0;i<9;i++){
            dp.add(new HashSet<>());
        }
        
        for(int i=1;i<9;i++){
            int repeatedNum = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatedNum);
            
            for(int j=1;j<i;j++ ){
                for(int a:dp.get(j)){
                    for(int b: dp.get(i-j)){
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) 
                            dp.get(i).add(a / b);
                    }
                }
            }
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        
        
        return -1;
    }
}