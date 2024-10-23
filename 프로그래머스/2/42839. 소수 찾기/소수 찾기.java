import java.util.ArrayList;

class Solution {

        static ArrayList<Integer> arr = new ArrayList<>();
        static boolean[] check = new boolean[7];

        public int solution(String numbers){
            int answer = 0;
            for(int i=0; i<numbers.length(); i++){
                dfs(numbers,"",i+1);
            }

            for(int i=0; i<arr.size(); i++){
                if(isPrime(arr.get(i))) answer++;
            }

            return answer;
        }

        public void dfs(String numbers, String s, int depth) {
            if(s.length() == depth){
                int num = Integer.parseInt(s);
                if(!arr.contains(num)){
                    arr.add(num);
                }
            }

            for(int i=0; i<numbers.length(); i++){
                if(!check[i]){
                    check[i] = true;
                    s += numbers.charAt(i);
                    dfs(numbers, s, depth);
                    check[i] = false;
                    s = s.substring(0, s.length()-1);
                }
            }

        }

        public static boolean isPrime(int n){
            if(n<2) return false;

            for(int i=2; i*i<=n; i++) {
                if(n % i == 0) return false;
            }

            return true;
        }
    }