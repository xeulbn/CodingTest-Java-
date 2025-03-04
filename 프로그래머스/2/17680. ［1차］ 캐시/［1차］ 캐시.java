import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int answer = 0;
        
        if(cacheSize==0){
            answer = cities.length*5;
        }else{
             Queue<String> cache = new LinkedList<>();
        
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toUpperCase();
            
            if(!cache.contains(city)){
                answer+=5;
            }else{
                cache.remove(city);
                answer+=1;
            }
            cache.add(city);
            if(cache.size()>cacheSize){
                cache.poll();
            }
        }
        }
        
        return answer;
    }
}