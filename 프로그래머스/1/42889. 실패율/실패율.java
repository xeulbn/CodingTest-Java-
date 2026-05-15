import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> stageCount = new HashMap<>();

        for (int stage : stages) {
            stageCount.put(stage, stageCount.getOrDefault(stage, 0)+1);
        }
        List<StageFailure> failureList = new ArrayList<>();
        
        int peopleCnt= stages.length;
        
        for (int stage = 1; stage <= N; stage++) {
            int failCount = stageCount.getOrDefault(stage, 0);

            double failureRate = peopleCnt==0 ? 0 : (double) failCount/peopleCnt;

            failureList.add(new StageFailure(stage, failureRate));

            peopleCnt -= failCount;
        }
        
        failureList.sort((a,b)->{
            if (a.failureRate == b.failureRate) {
                return Integer.compare(a.stage, b.stage);
            }

            return Double.compare(b.failureRate, a.failureRate);
        });
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = failureList.get(i).stage;
        }

        return answer;
        
        
    }
    
    public static class StageFailure{
        int stage;
        double failureRate;
        
        public StageFailure(int stage,double failureRate){
            this.stage=stage;
            this.failureRate=failureRate;
        }
    }
}