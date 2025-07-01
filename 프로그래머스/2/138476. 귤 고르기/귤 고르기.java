import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int size:tangerine){
            map.put(size,map.getOrDefault(size,0)+1);
        }
        
        ArrayList<Integer> countList= new ArrayList<>(map.values());
        countList.sort((a,b)->b-a);
        
        int answer=0;
        for(int count : countList){
            k-=count;
            answer++;
            if(k<=0){
                break;
            }
        }
    
        
        return answer;
    }
}