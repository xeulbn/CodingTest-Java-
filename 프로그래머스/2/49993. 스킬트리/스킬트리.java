import java.util.*;


class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = (int) Arrays.stream(skill_trees)
                    .map(value ->value.replaceAll("[^"+skill+"^]",""))
                    .filter(skill::startsWith).count();


            return answer;
    }
}