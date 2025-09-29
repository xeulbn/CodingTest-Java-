import java.util.*;
import java.util.regex.Pattern;

class Solution {
    
    public int[] check;
    public Set<Integer> uniqueSets = new HashSet<>();
    

    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        check=new int[banned_id.length];
        
        for(int i=0;i<banned_id.length;i++){
            banned_id[i]=toRegex(banned_id[i]);
        }
        
        List<List<Integer>> matched = new ArrayList<>();
        for(int i=0;i<banned_id.length;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<user_id.length;j++){
                if(Pattern.matches(banned_id[i],user_id[j])){
                    check[i]++;
                    list.add(j);
                }
            }
            matched.add(list);
        }
        
        dfs(0,0,matched);
        
        return uniqueSets.size();
    }
    
    public void dfs(int index, int bit, List<List<Integer>> matched){
        if (index == matched.size()) {
            uniqueSets.add(bit);
            return;
        }
        for (int userIdx : matched.get(index)) {
            if ((bit & (1 << userIdx)) != 0) 
                continue; 
            dfs(index + 1, bit | (1 << userIdx), matched);
        }
    }
    
    public String toRegex(String id){
        StringBuilder sb = new StringBuilder();
        for(char c: id.toCharArray()){
            if(c=='*'){
                sb.append(".");
            }else{
                sb.append(c);
            }
        }
        return "^" + sb.toString() + "$";
    }
}