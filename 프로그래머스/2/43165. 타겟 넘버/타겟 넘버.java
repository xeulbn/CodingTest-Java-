class Solution {
    
    private static int wayToMake=0;
    
    public int solution(int[] numbers, int target) {
        wayToMake = 0;
        dfs(numbers,target,0,0);
        return wayToMake;
    }
    
    private void dfs(int[] map, int target,int index, int current){
        if (index == map.length) {
            if (target == current) {
                wayToMake++;
            }
            return;
        }
        
        dfs(map, target, index+1, current+map[index]);
        dfs(map, target, index+1, current-map[index]);
    }
}