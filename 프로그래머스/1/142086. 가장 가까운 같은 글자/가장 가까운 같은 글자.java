import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> alphabet = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (alphabet.containsKey(ch)) {
                int prevIndex = alphabet.get(ch);
                answer[i] = i-prevIndex;
            } else {
                answer[i] = -1;
            }

            alphabet.put(ch, i);
        }

        return answer;
    }
}