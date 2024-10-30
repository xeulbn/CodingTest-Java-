class Solution {
        public int solution(int storey) {
            int answer = 0;

            while(storey != 0){
                int one = storey%10;
                int ten = (storey/10)%10;

                if(one>5){
                    answer+=(10-one);
                    storey +=10;
                }else if(one==5){
                    answer+=one;
                    if(ten<5){
                        storey+=0;
                    }else{
                        storey+=10;
                    }
                }else{
                    answer+=one;
                }

                storey/=10;
            }
            
            return answer;
        }
    }