import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer =0;
        int totalPicks = picks[0]+picks[1]+picks[2];
        int numBlocks = Math.min((minerals.length+4)/5,totalPicks);
        
        List<int[]> blocks = new ArrayList<>();
        
        for(int i=0;i<numBlocks;i++){
            int [] count = new int[3];
            for(int j=i*5;j<Math.min((i + 1) * 5, minerals.length);j++){
                if (minerals[j].equals("diamond")){
                    count[0]++;
                }else if(minerals[j].equals("iron")){
                    count[1]++;
                }else{
                    count[2]++;
                }
            }
            blocks.add(count);
        }
        
        blocks.sort((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            if (a[1] != b[1]) return b[1] - a[1]; 
            return b[2] - a[2]; 
        });

        
        for(int[] block: blocks){
            int pickType; // 0: 다이아, 1: 철, 2: 돌

            // 곡괭이가 남아있는지 확인하면서 가장 적절한 곡괭이 선택
            if (picks[0] > 0) { // 다이아 곡괭이 있으면 최우선 사용
                pickType = 0;
            } else if (picks[1] > 0) { // 철 곡괭이 있으면 사용
                pickType = 1;
            } else { // 돌 곡괭이 사용
                pickType = 2;
            }

            // 피로도 계산
            if (pickType == 0) { // 다이아 곡괭이
                answer += block[0] * 1 + block[1] * 1 + block[2] * 1;
            } else if (pickType == 1) { // 철 곡괭이
                answer += block[0] * 5 + block[1] * 1 + block[2] * 1;
            } else { // 돌 곡괭이
                answer += block[0] * 25 + block[1] * 5 + block[2] * 1;
            }

            picks[pickType]--;
        }
        
        
        return answer;
    }
}