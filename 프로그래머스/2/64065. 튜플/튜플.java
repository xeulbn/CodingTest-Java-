import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] sets = s.split("\\},\\{");
        
        Arrays.sort(sets, (a, b) -> a.length() - b.length());
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        for (String set : sets) {
            String[] numbers = set.split(",");

            for (String num : numbers) {
                int value = Integer.parseInt(num);

                if (!seen.contains(value)) {
                    seen.add(value);
                    result.add(value);
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}