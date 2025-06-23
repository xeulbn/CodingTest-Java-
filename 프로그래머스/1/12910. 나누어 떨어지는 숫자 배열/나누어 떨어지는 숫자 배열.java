import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        
        int flag=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                list.add(arr[i]);
                flag++;
            }
        }
        
        if(flag==0){
            list.add(-1);
        }
        
        int[] answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}