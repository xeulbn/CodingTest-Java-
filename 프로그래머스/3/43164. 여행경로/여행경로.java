import java.util.*;

class Solution {
    
    public static List<List<String>> map;
    public static boolean[] visited;
    
    public class Node{
        String start;
        String end;
        Node(String start,String end){
            this.start=start;
            this.end=end;
        }
    }
    
    
    public String[] solution(String[][] tickets) {
        map = new ArrayList<>();
        visited=new boolean[tickets.length];
            
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN")){
                List<String> list = new ArrayList<>();
                list.add("ICN");
                visited[i]=true;
                list.add(tickets[i][1]);
                dfs(tickets,i,list);
                visited[i]=false;
            }
        }
        
        Collections.sort(map,(a,b)->{
            for(int i=0;i<a.size();i++){
                int compare= a.get(i).compareTo(b.get(i));
                if(compare != 0){
                    return compare;
                }
            }
            return 0;
        });
        
        List<String> answer = map.get(0);
        return answer.toArray(new String[answer.size()]);
    }
    
    public void dfs(String[][] tickets,int begin, List<String> list){
        if(list.size()==tickets.length+1){
            map.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!visited[i]&&tickets[i][0].equals(tickets[begin][1])){
                visited[i]=true;
                list.add(tickets[i][1]);
                dfs(tickets,i,list);
                visited[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}