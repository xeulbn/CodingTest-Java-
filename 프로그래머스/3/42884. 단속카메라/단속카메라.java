import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes,new Comparator<int[]>(){
            @Override
            public int compare(int[]routes1,int[]routes2){
                return routes1[1]-routes2[1];
            }
        });
        
        int indexCam=Integer.MIN_VALUE;
        
        for(int[] route:routes ){
            if(route[0]>indexCam){
                indexCam=route[1];
                answer++;
            }
        }
        
        return answer;
    }
}