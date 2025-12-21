import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
                    
        for (int discountIndex = 0; discountIndex <= discount.length - 10; discountIndex++) {

            int satisfied = 0; 

            for (int i = 0; i < want.length; i++) {
                int count = 0;

                for (int j = discountIndex; j < discountIndex + 10; j++) {
                    if (want[i].equals(discount[j])) {
                        count++;
                    }
                }

                if (count == number[i]) {
                    satisfied++;
                }
            }

            if (satisfied == want.length) {
                answer++;
            }
        }

        return answer;
    }
}