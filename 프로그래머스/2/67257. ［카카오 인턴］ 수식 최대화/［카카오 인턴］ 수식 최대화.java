import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        int expressionSize = expression.length();
        
        List<Long> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<expressionSize;i++){
            char check = expression.charAt(i);
            if(check>='0'&& check<='9'){
                sb.append(check);
            }else{
                ops.add(check);
                numbers.add(Long.parseLong(sb.toString()));
                sb=new StringBuilder();
            }
        }
        numbers.add(Long.parseLong(sb.toString()));
        
        //기호 숫자 분리 끝.
        
        char[][] priorities = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'}
        };
        
        for (char[] priority : priorities) {
            List<Long> tempNumbers = new ArrayList<>(numbers);
            List<Character> tempOps = new ArrayList<>(ops);

            for (char op : priority) {
                for (int i = 0; i < tempOps.size(); i++) {
                    if (tempOps.get(i) == op) {
                        long result = calculate(
                            tempNumbers.get(i),
                            tempNumbers.get(i + 1),
                            op
                        );

                        tempNumbers.set(i, result);
                        tempNumbers.remove(i + 1);
                        tempOps.remove(i);

                        i--;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(tempNumbers.get(0)));
        }
        
        return answer;
    }
    
    private long calculate(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        }

        if (op == '-') {
            return a - b;
        }

        return a * b;
    }
}