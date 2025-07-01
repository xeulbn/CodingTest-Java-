import java.util.*;

class Solution {
    public boolean solution(int x) {
        int sum=0;
        int tmpX=x;
        List<Integer> all=new ArrayList<>();
        while (x>0){
            all.add(x%10);
            x=x/10;
        }
        
        for(int i : all){
            sum+=i;
        }
        
        if(tmpX%sum==0){
            return true;
        }else{
            return false;
        }
    }
}