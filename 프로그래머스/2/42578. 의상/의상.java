import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        String[] str = new String[clothes.length];

        for (int i = 0; i < clothes.length; i++) {
            str[i] = clothes[i][1];
            if (map.get(clothes[i][1]) == null) {
                map.put(clothes[i][1], 1);
            }

            else if (map.get(clothes[i][1]) != null) {
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }
        }

        String[] str2 =  Arrays.stream(str).distinct().toArray(String[]::new);

        int value = 1;
        for (int i = 0; i < str2.length; i++) {
            value *= (map.get(str2[i])+1);
        }

        answer = value -1;

        return answer;
    }
}