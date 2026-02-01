import java.util.*;

class Solution {
    
    public int solution(String numbers){
        int[] number = new int[numbers.length()];

        for(int i=0;i<numbers.length();i++){
            number[i] = numbers.charAt(i) - '0';
        }

        boolean[] visited = new boolean[number.length];
        Set<Integer> made = new HashSet<>();          
        dfs(number, visited, new ArrayList<>(), made);
        
        int count = 0;
        for (int x : made) {
            if (isPrime(x)) count++;
        }
        return count;
    }

    public void dfs(int[] number, boolean[] visited, List<Integer> curr, Set<Integer> made){
        if(!curr.isEmpty()){
            int val = 0;
            for(int d : curr){
                val = val * 10 + d;
            }
            made.add(val);
        }
        
        for(int i=0;i<number.length;i++){
            if(visited[i]) 
                continue;

            visited[i] = true;
            curr.add(number[i]);

            dfs(number, visited, curr, made);

            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) 
            return false;
        
        if (n == 2) 
            return true;
        
        if (n % 2 == 0) 
            return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) 
                return false;
        }
        return true;
    }
    
}