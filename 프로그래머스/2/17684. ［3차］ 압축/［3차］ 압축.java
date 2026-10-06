
import java.util.*;

class Solution {
    
    private static Map<String, Integer> dictionary;
    
    public int[] solution(String msg) {
        String[] msgSplit = msg.split("");
        dictionary = makeDictionary();
        List<Integer> answer = new ArrayList<>();
        
        int i = 0;
        int nextIndex = 27;

        while (i<msgSplit.length) {
            String w = msgSplit[i];
            int end = i+1;

            // 다음 글자를 붙인 문자열도 사전에 있으면 계속 확장
            while (end < msgSplit.length
                    && dictionary.containsKey(w + msgSplit[end])) {
                w += msgSplit[end];
                end++;
            }

            // 1. 사전에 있는 가장 긴 문자열 w의 번호를 answer에 추가
            answer.add(dictionary.get(w));

            if (end < msgSplit.length) {
                // 2. w + msgSplit[end]를 nextIndex 번호로 사전에 등록
                dictionary.put(w + msgSplit[end], nextIndex);
                // 3. nextIndex 증가
                nextIndex+=1;
            }
            i = end;
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
    
    private Map<String, Integer> makeDictionary(){
        Map<String, Integer> result = new HashMap<>();
        
        for(int i=0;i<26;i++){
            result.put(String.valueOf((char) ('A' + i)),i+1);
        }
        return result;
    }
}