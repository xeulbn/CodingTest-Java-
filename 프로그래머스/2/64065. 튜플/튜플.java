import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] element = s.split("[{}]");
        List<String[]> groups = new ArrayList<>();
        
        for(String part : element){
            if(part.isEmpty()||part.equals(",")){
                continue;
            }
            String[] numbers = part.split(",");
            groups.add(numbers);
        }
        Collections.sort(groups,new StringLengthComparator());
        
        int maxSize = groups.get(groups.size() - 1).length;
        int[] answer = new int[maxSize];
        
        Set<String> compareSet = new HashSet<>();
        int answerIdx = 0;
        
        for(int i=0;i<groups.size();i++){
            String[] check = groups.get(i);
            for(int idx=0;idx<check.length;idx++){
                if(!compareSet.contains(check[idx])){
                    answer[answerIdx]=Integer.parseInt(check[idx]);
                    compareSet.add(check[idx]);
                    answerIdx+=1;
                }
            }
        }
        
        
        return answer;
        
    }
}

class StringLengthComparator implements Comparator<String[]> {
    @Override
    public int compare(String[] s1, String[] s2) {
        return Integer.compare(s1.length, s2.length);
    }
}