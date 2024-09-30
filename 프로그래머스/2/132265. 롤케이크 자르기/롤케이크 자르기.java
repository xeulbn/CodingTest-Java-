import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> counting = new HashMap<>();
        Set<Integer> countSet = new HashSet<>();

        for(int i=0;i<topping.length;i++){
            countSet.add(topping[i]);

            counting.put(i,countSet.size());
        }

        Set<Integer> brother = new HashSet<>();
        for(int i=topping.length-1;i>0;i--){
            brother.add(topping[i]);
            if(counting.get(i-1)== brother.size()){
                answer++;
            }
        }
        return answer;
    }
}