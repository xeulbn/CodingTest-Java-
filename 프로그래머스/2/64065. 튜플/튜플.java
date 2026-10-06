import java.util.*;

class Solution {
    
    private static Set<Integer> compare;
    
    public int[] solution(String s) {
        String[] str = s.split("[{}]");
        List<int[]> tuple = new ArrayList<>();
        compare = new HashSet<>();
        
        Arrays.sort(str,(a,b)->a.length()-b.length());
        for(int i=0;i<str.length;i++){
            if(str[i].isEmpty() || str[i].equals(",")){
                continue;
            }
            String[] parts = str[i].split(",");
            int[] tmp = new int[parts.length];

            for (int j = 0; j < parts.length; j++) {
                tmp[j] = Integer.parseInt(parts[j]);
            }

            tuple.add(tmp);
        }
        
        int[] answer =findTuple(tuple);
        
        return answer;
    }
    
    private int[] findTuple(List<int[]> numbers){
        List<Integer> returnValue = new ArrayList<>();
        
        for(int[] num : numbers){
            for(int i=0;i<num.length;i++){
                if(!compare.contains(num[i])){
                    compare.add(num[i]);
                    returnValue.add(num[i]);
                }
            }
        }
        return returnValue.stream().mapToInt(Integer::intValue).toArray();
    }
}