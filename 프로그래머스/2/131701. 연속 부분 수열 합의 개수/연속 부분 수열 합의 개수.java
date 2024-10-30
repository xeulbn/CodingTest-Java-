import java.util.HashSet;
import java.util.Set;

class Solution {
        public int solution(int[] elements) {
            int answer = 0;

            Set<Integer> sumOfSet= new HashSet<>();

            for(int size=1;size<= elements.length;size++){
                int sum=0;
                int start =0;

                for(int i=0;i<size;i++){
                    sum+=elements[i];
                }
                sumOfSet.add(sum);

                while(start<elements.length-1){
                    sum-=elements[start];
                    sum+=elements[(start+size)% elements.length];
                    start++;
                    sumOfSet.add(sum);
                }
            }
            answer=sumOfSet.size();

            return answer;
        }
    }