import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] aStudent = {1,2,3,4,5};
        int[] bStudent = {2,1,2,3,2,4,2,5};
        int[] cStudent = {3,3,1,1,2,2,4,4,5,5};
        
        int aScore = studentScore(aStudent,answers);
        int bScore = studentScore(bStudent,answers);
        int cScore = studentScore(cStudent,answers);
        
        int maxScore = Math.max(aScore, Math.max(bScore, cScore));

        List<Integer> result = new ArrayList<>();
        if (aScore == maxScore) 
            result.add(1);
        if (bScore == maxScore) 
            result.add(2);
        if (cScore == maxScore) 
            result.add(3);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int studentScore(int[] studentAnswer, int[] answers){
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (studentAnswer[i % studentAnswer.length] == answers[i]) {
                score++;
            }
        }
        return score;
    }
}