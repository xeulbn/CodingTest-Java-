    class Solution {
        public String solution(int n) {
            String[] numbers = {"4", "1", "2"};
            String answer = "";

            int num = n;

            while(num > 0){
                int remaind = num % 3;
                num /= 3;

                if(remaind == 0) num--;

                answer = numbers[remaind] + answer;
            }

            return answer;
        }
    }
