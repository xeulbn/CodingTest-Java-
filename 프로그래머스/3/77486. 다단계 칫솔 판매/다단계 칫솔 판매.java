import java.util.*;
class Solution {
    
    public Map<String,String> myParent = new HashMap<>();
    public Map<String,Integer> earnMoney = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            myParent.put(enroll[i],referral[i]);
            earnMoney.put(enroll[i],0);
        }
        
        for(int i=0;i<seller.length;i++){
            String curSeller= seller[i];
            int money = amount[i] * 100; 
            
            while (!"-".equals(curSeller) && money > 0) {
                int earnParent = money / 10;          
                int earnChild  = money - earnParent; 

                // 자식 돈 추가
                earnMoney.put(curSeller, earnMoney.get(curSeller) + earnChild);

                // 부모로 이동
                curSeller = myParent.get(curSeller);
                money = earnParent;
            }
        }
        
        
        for(int i=0;i<enroll.length;i++){
            answer[i]=earnMoney.get(enroll[i]);           
        }
        
        return answer;
    }
}