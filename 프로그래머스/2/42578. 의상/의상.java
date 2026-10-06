import java.util.*;


class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> clothMap = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){
            String[] cloth=clothes[i];
            String name = cloth[0];
            String sort = cloth[1];
            
            List<String> names = clothMap.getOrDefault(sort, new ArrayList<>());
            names.add(name);
            clothMap.put(sort, names);
        }
        
        int clothSortCnt = 1;

        for (String str : clothMap.keySet()) {
            int tmpCnt = clothMap.get(str).size();
            clothSortCnt *= (tmpCnt+1);
        }

        return clothSortCnt - 1;
    }
}