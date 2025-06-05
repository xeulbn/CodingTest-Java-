import java.util.*;
class Solution {
    
    public static Map<Integer,Node> map;
    public static int[][] dp;
    
    
    public int solution(int[] sales, int[][] links) {
        map=new HashMap<>();
        dp=new int[sales.length+1][2];
        
        HashSet<Integer> childrenSet=new HashSet<>();
        
        for (int[] a : links) {
            int parent = a[0];
            int child = a[1];
            childrenSet.add(child);
            
            if (!map.containsKey(parent)) {
                map.put(parent, new Node(0));
            }
            if (!map.containsKey(child)) {
                map.put(child, new Node(parent));
            } else {
                map.get(child).up = parent;
            }
            map.get(parent).children.add(child);
        }
        
        for (int i = 0; i < sales.length; i++) {
            int id = i + 1; 
            map.putIfAbsent(id, new Node(0));
            map.get(id).updateMoney(sales[i]);
        }
        
        int root=1;
        
        for(int id=1;id<=sales.length;id++){
            if(!childrenSet.contains(id)){
                root=id;
                break;
            }
        }
        
        dfs(root,dp);
        
        return Math.min(dp[root][0], dp[root][1]);
    }
    
    public void dfs(int curId, int[][] dp){
        Node curNode=map.get(curId);
        dp[curId][1]=curNode.money;
        dp[curId][0]=0;
        
        if(curNode.children.size()==0){
            return;
        }
        
        int sumForZero=0;
        int diff=Integer.MAX_VALUE;
        boolean childAttends= false;
        
        for(int child: curNode.children){
            dfs(child,dp);
            dp[curId][1] += Math.min(dp[child][0], dp[child][1]);
            
            sumForZero += Math.min(dp[child][0], dp[child][1]);
            if (dp[child][0] > dp[child][1]) {
                childAttends = true;
            }else{
                diff=Math.min(diff, dp[child][1] - dp[child][0]);
            }
        }
        
        dp[curId][0] = sumForZero;
        if (!childAttends) {
            dp[curId][0] += diff;
        }
        
    }
    
    class Node{
        int up;
        int money;
        List<Integer> children;
    
        Node(int up){
            this.up=up;
            children = new ArrayList<>();
        }
    
        void updateMoney(int money){
            this.money=money;
        }
    
    }
}

