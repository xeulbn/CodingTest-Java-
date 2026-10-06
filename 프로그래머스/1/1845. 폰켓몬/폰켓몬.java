import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int canGet = nums.length/2;
        Set<Integer> sortPokemon = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            if(!sortPokemon.contains(nums[i])){
                sortPokemon.add(nums[i]);
            }
        }
        
        if(canGet<sortPokemon.size()){
            return canGet;
        }else{
            return sortPokemon.size();
        }
    }
}